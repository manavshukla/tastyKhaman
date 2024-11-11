package com.aone.module.purchase.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.commons.InOutWardConstant;
import com.aone.commons.exceptions.OperationFailedException;
import com.aone.commons.utils.DateUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactTypeDataList;
import com.aone.module.contact.service.IContactService;
import com.aone.module.inOutWard.model.InOutWard;
import com.aone.module.inOutWard.service.IInOutWardService;
import com.aone.module.item.model.Item;
import com.aone.module.item.service.IItemService;
import com.aone.module.payments.constant.PaymentConstant;
import com.aone.module.payments.constant.PaymentEntryTypeConstant;
import com.aone.module.payments.model.PaymentsMaster;
import com.aone.module.payments.service.IPaymentsService;
import com.aone.module.purchase.dao.IPurchaseDao;
import com.aone.module.purchase.model.Purchase;
import com.aone.module.purchase.service.IPurchaseService;
import com.aone.module.purchaseDetails.model.PurchaseDetails;
import com.aone.module.purchaseDetails.service.IPurchaseDetailsService;
import com.aone.module.sales.model.SalesInitData;

@Lazy
@Service("purchaseServiceImpl")
public class PurchaseServiceImpl extends AbstractBaseMasterService<Purchase, Long, IPurchaseDao> implements
		IPurchaseService {
	
	private IPurchaseDao purchaseDao;
	private IPurchaseDetailsService purchaseDetailsService;
	private IInOutWardService inOutWardService;
	private IItemService itemService;
	private IContactService contactService;
	private IPaymentsService paymentsService;
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> init(RequestData<Purchase, Long> requestData) {
		Purchase purchase = requestData.getData();
		purchase.setVendorBillNo("PREFIX-" + System.currentTimeMillis() + "-SUFFIX");
		IResponseData<Purchase> responseData = new ResponseData<>(purchase, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> save(RequestData<Purchase, Long> requestData) {
		
		Purchase purchase  = requestData.getData();
		purchase.setPurchaseDate(DateUtils.formateDateOnly(purchase.getPurchaseDate()));
		// save purchase master
		purchase = getRepository().save(purchase);
		
		// save purchase details
		List<PurchaseDetails> purchaseDetailsList = requestData.getData().getPurchaseDetails();
		List<Item> itemList = new ArrayList<>(purchaseDetailsList.size());
		Item item = null;
		InOutWard inOutWard = null;
		List<InOutWard> inOutWardList = new ArrayList<>();
		for(PurchaseDetails purchaseDetails : purchaseDetailsList) {
			
			// create item list to update item data
			item = new Item();
			item.setId(purchaseDetails.getItemId());
			item.setStock(purchaseDetails.getOrderQuantity() - purchaseDetails.getReturnQty());
			// add item to list to update the stock
			itemList.add(item);
			
			// prepare data for in out ward stock details logs
			inOutWard = new InOutWard();
			inOutWard.setDate(LocalDateTime.now());
			inOutWard.setItemId(purchaseDetails.getItemId());
			inOutWard.setContactId(purchase.getContactId());
			inOutWard.setQuantity(item.getStock());
			inOutWard.setPrice(purchaseDetails.getPrice());
			inOutWard.setPurchaseId(purchase.getId());
			inOutWard.setSource(InOutWardConstant.PURCHASE.getValue());
			// in out ward, adding to list
			inOutWardList.add(inOutWard);
			
			// save purchase details list
			purchaseDetails.setPurchaseId(purchase.getId());
			purchaseDetailsService.save(purchaseDetails);
		}
		
		// update item stock
		if (getItemService().updateItemStock(itemList) != itemList.size()) {
			throw new OperationFailedException("Error occurred while updating the item stock");
		}
		
		inOutWardService.saveOrUpdateAll(inOutWardList);

		PaymentsMaster customerPayment = new PaymentsMaster();
		customerPayment.setAmount(purchase.getGrossAmount());
		customerPayment.setBillId(purchase.getId());
		customerPayment.setBillNo(String.valueOf(purchase.getId()));
		customerPayment.setTransactionDate(purchase.getPurchaseDate());
		customerPayment.setContactId(purchase.getContactId());
		customerPayment.setPaymentMode("Cash");
		customerPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
		customerPayment.setEntryType(PaymentEntryTypeConstant.PURCHASE.getValue());
		customerPayment.setSystemGenerated(true);
		customerPayment.setDescription("Raw Material Purchase");
		paymentsService.save(customerPayment);
		
		IResponseData<Purchase> responseData = new ResponseData<>(purchase, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> update(RequestData<Purchase, Long> requestData) {
		
		Purchase purchase  = requestData.getData();
		purchase.setPurchaseDate(DateUtils.formateDateOnly(purchase.getPurchaseDate()));

		// save purchase master1
		purchase = getRepository().update(purchase);

		List<PurchaseDetails> oldPurchaseDetailsList = purchaseDetailsService.getByPurchaseId(purchase.getId());
		Map<Long, PurchaseDetails> itemWisePurchaseDetails = new HashMap<>();
		
		if(oldPurchaseDetailsList != null) {
			for(PurchaseDetails oldPurchaseDetails : oldPurchaseDetailsList) {
				itemWisePurchaseDetails.put(oldPurchaseDetails.getItemId(), oldPurchaseDetails);
			}
		}
		
		// save purchase details
		List<PurchaseDetails> purchaseDetailsList = requestData.getData().getPurchaseDetails();
		purchaseDetailsService.deleteByPurchaseId(purchase.getId());
		
		List<Item> itemList = new ArrayList<>(purchaseDetailsList.size());
		Item item = null;
		InOutWard inOutWard = null;
		List<InOutWard> inOutWardList = new ArrayList<>();
		double qtyToUpdateInStock;
		PurchaseDetails oldPurchaseDetails;
		for(PurchaseDetails purchaseDetails : purchaseDetailsList) {
			purchaseDetails.setPurchaseId(purchase.getId());
			purchaseDetails.setId(null);
			purchaseDetailsService.saveOrUpdate(purchaseDetails);
			
			
			// create item list to update item stock data
			// set item stock details				
			qtyToUpdateInStock = purchaseDetails.getOrderQuantity() - purchaseDetails.getReturnQty();
			oldPurchaseDetails = itemWisePurchaseDetails.remove(purchaseDetails.getItemId());
			if(oldPurchaseDetails!= null) {
				qtyToUpdateInStock = qtyToUpdateInStock - (oldPurchaseDetails.getOrderQuantity() - oldPurchaseDetails.getReturnQty());
			}
			
			item = new Item();
			item.setId(purchaseDetails.getItemId());
			item.setStock(qtyToUpdateInStock);
			// add item to list to update the stock
			itemList.add(item);
			
			// prepare data for in out ward stock details logs
			inOutWard = new InOutWard();
			inOutWard.setDate(LocalDateTime.now());
			inOutWard.setItemId(purchaseDetails.getItemId());
			inOutWard.setContactId(purchase.getContactId());
			inOutWard.setQuantity(item.getStock());
			inOutWard.setPrice(purchaseDetails.getPrice());
			inOutWard.setPurchaseId(purchase.getId());
			inOutWard.setSource(InOutWardConstant.PURCHASE.getValue());
			// in out ward, adding to list
			inOutWardList.add(inOutWard);
		}
		
		// for the item which are deleted from bill
		if(!itemWisePurchaseDetails.isEmpty()) {
			for(Map.Entry<Long, PurchaseDetails> entry : itemWisePurchaseDetails.entrySet()) {
				oldPurchaseDetails = entry.getValue();
				item = new Item();
				item.setId(oldPurchaseDetails.getItemId());
				item.setStock(-1 * (oldPurchaseDetails.getOrderQuantity() - oldPurchaseDetails.getReturnQty()));
				itemList.add(item);
				
				// prepare data for in out ward stock details logs
				inOutWard = new InOutWard();
				inOutWard.setDate(LocalDateTime.now());
				inOutWard.setItemId(oldPurchaseDetails.getItemId());
				inOutWard.setContactId(purchase.getContactId());
				inOutWard.setQuantity(item.getStock());
				inOutWard.setPrice(oldPurchaseDetails.getPrice());
				inOutWard.setPurchaseId(oldPurchaseDetails.getId());
				inOutWard.setSource(InOutWardConstant.PURCHASE.getValue());
				
				// in out ward, adding to list
				inOutWardList.add(inOutWard);
			}
		}
		
		// update item stock
		if (getItemService().updateItemStock(itemList) != itemList.size()) {
			throw new OperationFailedException("Error occurred while updating the item stock");
		}
		
		inOutWardService.saveOrUpdateAll(inOutWardList);
		
		// delete all payment details for current saleId/ billId
		paymentsService.deleteByBillId(purchase.getId(), PaymentEntryTypeConstant.PURCHASE.getValue());
				
		PaymentsMaster customerPayment = new PaymentsMaster();
		customerPayment.setAmount(purchase.getGrossAmount());
		customerPayment.setBillId(purchase.getId());
		customerPayment.setBillNo(String.valueOf(purchase.getId()));
		customerPayment.setTransactionDate(purchase.getPurchaseDate());
		customerPayment.setContactId(purchase.getContactId());
		customerPayment.setPaymentMode("Cash");
		customerPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
		customerPayment.setEntryType(PaymentEntryTypeConstant.PURCHASE.getValue());
		customerPayment.setSystemGenerated(true);
		customerPayment.setDescription("Raw Material Purchase");
		paymentsService.save(customerPayment);
		
		IResponseData<Purchase> responseData = new ResponseData<>(purchase, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> getById(RequestData<Purchase, Long> requestData) {
		
		if(requestData.getId() == null) {
			IResponseData<Purchase> responseData = new ResponseData<>(requestData.getData(), ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		// save purchase master
		Purchase purchase = getRepository().getById(requestData.getId());
		
		SalesInitData salesInitData = new SalesInitData();
		purchase.setSalesInitData(salesInitData);
		
		RequestData<SearchData<Contact>, Long> contactReqData = new RequestData<>();
		SearchData<Contact> contactSearchData = new SearchData<>();
		contactReqData.setData(contactSearchData);
		ContactTypeDataList contactTypeDataList = new ContactTypeDataList();
		contactTypeDataList.setVendorDealerContactList(contactService.getVendorDealer(contactReqData).getBody().getData().getContactList());
		salesInitData.setContacts(contactTypeDataList);
		
		RequestData<SearchData<Item>, Long> itemReqData = new RequestData<>();
		SearchData<Item> itemSearchData = new SearchData<>();
		itemReqData.setData(itemSearchData);
		salesInitData.setItemList(itemService.getRowMaterialListData(itemReqData).getBody().getDataList());
		
		// setting purchase item details
		purchase.setPurchaseDetails(purchaseDetailsService.getByPurchaseId(purchase.getId()));
		
		// set customerDetails
		Contact contact = new Contact();
		contact.setId(purchase.getContactId());
		purchase.setContact(contactService.getById(contact));
		
		purchase.setDefaultValueForObject();
		IResponseData<Purchase> responseData = new ResponseData<>(purchase, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> delete(RequestData<Purchase, Long> requestData) {
		ResponseEntity<IResponseData<Purchase>> responseEntity = super.delete(requestData);
		if(ResultCodeConstant.SUCCESS.getResultCode() != responseEntity.getBody().getResponseCode()) {
			return responseEntity;
		}
		
		Purchase purchase = responseEntity.getBody().getData();
		
		List<PurchaseDetails> purchaseDetailsList = purchaseDetailsService.getByPurchaseId(purchase.getId());
		List<Item> itemList = new ArrayList<>(purchaseDetailsList.size());
		Item item = null;
		InOutWard inOutWard = null;
		List<InOutWard> inOutWardList = new ArrayList<>();
		for(PurchaseDetails oldPurchaseDetails : purchaseDetailsList) {
			item = new Item();
			item.setId(oldPurchaseDetails.getItemId());
			item.setStock(-1 * (oldPurchaseDetails.getOrderQuantity() - oldPurchaseDetails.getReturnQty()));
			itemList.add(item);
			
			// prepare data for in out ward stock details logs
			inOutWard = new InOutWard();
			inOutWard.setDate(LocalDateTime.now());
			inOutWard.setItemId(oldPurchaseDetails.getItemId());
			inOutWard.setContactId(purchase.getContactId());
			inOutWard.setQuantity(item.getStock());
			inOutWard.setPrice(oldPurchaseDetails.getPrice());
			inOutWard.setPurchaseId(oldPurchaseDetails.getId());
			inOutWard.setSource(InOutWardConstant.PURCHASE.getValue());
			
			// in out ward, adding to list
			inOutWardList.add(inOutWard);
		}
		
		// update item stock
		if (getItemService().updateItemStock(itemList) != itemList.size()) {
			throw new OperationFailedException("Error occurred while updating the item stock");
		}
		
		inOutWardService.saveOrUpdateAll(inOutWardList);
		
		// delete purchase details items
		purchaseDetailsService.deleteByPurchaseId(responseEntity.getBody().getData().getId());
		
		// delete customer and advance details	
		paymentsService.deleteByBillId(responseEntity.getBody().getData().getId(), PaymentEntryTypeConstant.PURCHASE.getValue());
		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<IResponseData<Purchase>> getActiveData(RequestData<SearchData<Purchase>, Long> requestData) {
		ResponseEntity<IResponseData<Purchase>> responseEntity = super.getActiveData(requestData);
		List<Purchase> purchaseList = responseEntity.getBody().getDataList();
		
		// set customer details
		Contact contact = new Contact();
		for(Purchase purchase: purchaseList) {
			contact.setId(purchase.getContactId());
			purchase.setContact(contactService.getById(contact));
		}
		return responseEntity; 
	}
	
	public IPurchaseDetailsService getPurchaseDetailsService() {
		return purchaseDetailsService;
	}

	@Autowired        
	@Qualifier(value="purchaseDetailsServiceImpl")
	public void setPurchaseDetailsService(IPurchaseDetailsService purchaseDetailsService) {
		this.purchaseDetailsService = purchaseDetailsService;
	}

	@Override
	public IPurchaseDao getRepository() {
		return getPurchaseDao();
	}
	
	public IInOutWardService getInOutWardService() {
		return inOutWardService;
	}

	@Autowired        
	@Qualifier(value="inOutWardServiceImpl")
	public void setInOutWardService(IInOutWardService inOutWardService) {
		this.inOutWardService = inOutWardService;
	}

	public IPurchaseDao getPurchaseDao() {
		return purchaseDao;
	}

	@Autowired
	@Qualifier(value = "purchaseDaoImpl")
	public void setPurchaseDao(IPurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	public IItemService getItemService() {
		return itemService;
	}

	@Autowired        
	@Qualifier(value="itemServiceImpl")
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public IContactService getContactService() {
		return contactService;
	}

	@Autowired        
	@Qualifier(value="contactServiceImpl")
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	public IPaymentsService getPaymentsService() {
		return paymentsService;
	}

	@Autowired
	@Qualifier(value="paymentsServiceImpl")
	public void setPaymentsService(IPaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}
	
}