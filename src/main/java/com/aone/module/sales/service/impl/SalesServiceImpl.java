package com.aone.module.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.commons.ModuleName;
import com.aone.commons.utils.DateUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.address.model.Address;
import com.aone.module.address.model.AddressDataList;
import com.aone.module.address.service.IAddressService;
import com.aone.module.city.model.City;
import com.aone.module.city.service.ICityService;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactTypeDataList;
import com.aone.module.contact.service.IContactService;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;
import com.aone.module.item.model.Item;
import com.aone.module.item.service.IItemService;
import com.aone.module.payments.constant.PaymentConstant;
import com.aone.module.payments.constant.PaymentEntryTypeConstant;
import com.aone.module.payments.model.PaymentsMaster;
import com.aone.module.payments.service.IPaymentsService;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;
import com.aone.module.saleWorkerHelper.service.ISaleWorkerHelperService;
import com.aone.module.sales.constant.SalesOrderTypeEnum;
import com.aone.module.sales.dao.ISalesDao;
import com.aone.module.sales.model.Sales;
import com.aone.module.sales.model.SalesInitData;
import com.aone.module.sales.service.ISalesService;
import com.aone.module.salesDetails.model.SalesDetails;
import com.aone.module.salesDetails.service.ISalesDetailsService;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;
import com.aone.module.salesDriverDetails.service.ISaleDriverDetailsService;
import com.aone.module.salesThirdParty.model.SalesThirdParty;
import com.aone.module.salesThirdParty.service.ISalesThirdPartyService;
import com.aone.module.state.model.State;
import com.aone.module.state.service.IStateService;

@Lazy
@Service("salesServiceImpl")
public class SalesServiceImpl extends AbstractBaseMasterService<Sales, Long, ISalesDao> implements ISalesService {

	private ISalesDao salesDao;
	private ISalesDetailsService salesDetailsService;
	private IAddressService addressService;
	private ISaleWorkerHelperService saleWorkerHelperService;
	private ISalesThirdPartyService salesThirdPartyService;
	private ISaleDriverDetailsService saleDriverDetailsService;
	private IPaymentsService paymentsService;
	private IContactService contactService;
	private IItemService itemService;
	private ICountryService countryService;
	private IStateService stateService;
	private ICityService cityService;

	public ICityService getCityService() {
		return cityService;
	}

	@Autowired
	@Qualifier(value = "cityServiceImpl")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}

	public IStateService getStateService() {
		return stateService;
	}

	@Autowired
	@Qualifier(value = "stateServiceImpl")
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}

	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	@Qualifier(value = "countryServiceImpl")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}

	public IContactService getContactService() {
		return contactService;
	}

	@Autowired
	@Qualifier(value = "contactServiceImpl")
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}

	public IPaymentsService getPaymentsService() {
		return paymentsService;
	}

	@Autowired
	@Qualifier(value = "paymentsServiceImpl")
	public void setPaymentsService(IPaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	public ISaleDriverDetailsService getSaleDriverDetailsService() {
		return saleDriverDetailsService;
	}

	@Autowired
	@Qualifier(value = "saleDriverDetailsServiceImpl")
	public void setSaleDriverDetailsService(ISaleDriverDetailsService saleDriverDetailsService) {
		this.saleDriverDetailsService = saleDriverDetailsService;
	}

	public ISalesThirdPartyService getSalesThirdPartyService() {
		return salesThirdPartyService;
	}

	@Autowired
	@Qualifier(value = "salesThirdPartyServiceImpl")
	public void setSalesThirdPartyService(ISalesThirdPartyService salesThirdPartyService) {
		this.salesThirdPartyService = salesThirdPartyService;
	}

	public ISaleWorkerHelperService getSaleWorkerHelperService() {
		return saleWorkerHelperService;
	}

	@Autowired
	@Qualifier(value = "saleWorkerHelperServiceImpl")
	public void setSaleWorkerHelperService(ISaleWorkerHelperService saleWorkerHelperService) {
		this.saleWorkerHelperService = saleWorkerHelperService;
	}

	public ISalesDetailsService getSalesDetailsService() {
		return salesDetailsService;
	}

	@Autowired
	@Qualifier(value = "salesDetailsServiceImpl")
	public void setSalesDetailsService(ISalesDetailsService salesDetailsService) {
		this.salesDetailsService = salesDetailsService;
	}

	public IItemService getItemService() {
		return itemService;
	}

	@Autowired
	@Qualifier(value = "itemServiceImpl")
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public ISalesDao getRepository() {
		return getSalesDao();
	}

	public ISalesDao getSalesDao() {
		return salesDao;
	}

	@Autowired
	@Qualifier(value = "salesDaoImpl")
	public void setSalesDao(ISalesDao salesDao) {
		this.salesDao = salesDao;
	}

	public IAddressService getAddressService() {
		return addressService;
	}

	@Autowired
	@Qualifier(value = "addressServiceImpl")
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> init(RequestData<Sales, Long> requestData) {
		Sales sales = requestData.getData();
		IResponseData<Sales> responseData = new ResponseData<>(sales, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		ResponseEntity<IResponseData<Sales>> responseEntity = new ResponseEntity<>(responseData, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> save(RequestData<Sales, Long> requestData) {

		Sales sales = requestData.getData();
		ResultCodeConstant resultCodeConstant = this.save(sales);

		IResponseData<Sales> responseData = new ResponseData<>(sales, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant save(Sales sales) {
		ResultCodeConstant resultCodeConstant = validateData(sales);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}

		// save sales master
		sales.setBookingDate(DateUtils.formateDateOnly(sales.getBookingDate()));
		sales.setOrderDate(DateUtils.formateDateOnly(sales.getOrderDate()));

		sales = getRepository().save(sales);

		// save sales details
		List<SalesDetails> salesDetailsList = sales.getSalesDetails();
		for (SalesDetails salesDetails : salesDetailsList) {
			salesDetails.setSalesId(sales.getId());
			salesDetailsService.save(salesDetails);
		}

		// add customer payment details
		if (SalesOrderTypeEnum.DAILY_ORDER != SalesOrderTypeEnum.getOrderType(sales.getOrderType())) {
			PaymentsMaster customerPayment = new PaymentsMaster();
			customerPayment.setAmount(sales.getGrossAmount());
			customerPayment.setBillId(sales.getId());
			customerPayment.setBillNo(String.valueOf(sales.getId()));
			customerPayment.setTransactionDate(sales.getOrderDate());
			customerPayment.setContactId(sales.getContactId());
			customerPayment.setPaymentMode("Cash");
			customerPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
			customerPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
			customerPayment.setSystemGenerated(true);
			customerPayment.setDescription(SalesOrderTypeEnum.getOrderType(sales.getOrderType()).name());
			paymentsService.save(customerPayment);

			if (sales.getAdvance() > 0) {
				customerPayment = new PaymentsMaster();
				customerPayment.setAmount(sales.getAdvance());
				customerPayment.setBillId(sales.getId());
				customerPayment.setBillNo(String.valueOf(sales.getId()));
				customerPayment.setTransactionDate(sales.getOrderDate());
				customerPayment.setContactId(sales.getContactId());
				customerPayment.setPaymentMode("Cash");
				customerPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				customerPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				customerPayment.setSystemGenerated(true);
				customerPayment.setDescription("Advance for Bill No:" + sales.getId());
				paymentsService.save(customerPayment);
			}

		}

		PaymentsMaster workerHelperPayment = null;
		PaymentsMaster thirdPartyPayment = null;
		PaymentsMaster driverPayment = null;
		if (sales.getOrderType() == SalesOrderTypeEnum.WHOLE_SALE_ORDER.getValue()) {
			// save driver details
			List<SaleDriverDetails> salesDriverDetailList = sales.getSaleDriverDetails();
			for (SaleDriverDetails saleDriverDetails : salesDriverDetailList) {
				saleDriverDetails.setSalesId(sales.getId());
				saleDriverDetailsService.save(saleDriverDetails);

				driverPayment = new PaymentsMaster();
				driverPayment.setAmount(saleDriverDetails.getRate());
				driverPayment.setBillId(sales.getId());
				driverPayment.setBillNo(String.valueOf(sales.getId()));
				driverPayment.setTransactionDate(sales.getBookingDate());
				driverPayment.setContactId(saleDriverDetails.getContactId());
				driverPayment.setPaymentMode("Cash");
				driverPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				driverPayment.setSystemGenerated(true);
				driverPayment.setDescription("Vehicle No.:" + saleDriverDetails.getVehicleNo());
				paymentsService.save(driverPayment);

				if (saleDriverDetails.getAdvance() > 0) {
					driverPayment = new PaymentsMaster();
					driverPayment.setAmount(saleDriverDetails.getAdvance());
					driverPayment.setBillId(sales.getId());
					driverPayment.setBillNo(String.valueOf(sales.getId()));
					driverPayment.setTransactionDate(sales.getBookingDate());
					driverPayment.setContactId(saleDriverDetails.getContactId());
					driverPayment.setPaymentMode("Cash");
					driverPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					driverPayment.setSystemGenerated(true);
					driverPayment.setDescription("Advance Given, Vehicle No.:" + saleDriverDetails.getVehicleNo());
					paymentsService.save(driverPayment);
				}
			}
		}
		if (sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue()) {
			// save address details
			Address shippingAddress = sales.getShippingAddress();
			shippingAddress.setForeinKey(sales.getId());
			shippingAddress.setModuleName(ModuleName.SALES_SHIPPING_ADDRESS.getValue());
			addressService.save(shippingAddress);

			// save worker details
			List<SaleWorkerHelper> saleWorkerHelperList = sales.getSaleWorkerHelpers();
			for (SaleWorkerHelper saleWorkerHelper : saleWorkerHelperList) {
				saleWorkerHelper.setSalesId(sales.getId());
				saleWorkerHelperService.save(saleWorkerHelper);

				workerHelperPayment = new PaymentsMaster();
				workerHelperPayment.setAmount(saleWorkerHelper.getRate());
				workerHelperPayment.setBillId(sales.getId());
				workerHelperPayment.setBillNo(String.valueOf(sales.getId()));
				workerHelperPayment.setTransactionDate(sales.getBookingDate());
				workerHelperPayment.setContactId(saleWorkerHelper.getContactId());
				workerHelperPayment.setPaymentMode("Cash");
				workerHelperPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				workerHelperPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				workerHelperPayment.setSystemGenerated(true);
				workerHelperPayment.setDescription(saleWorkerHelper.getRole());
				paymentsService.save(workerHelperPayment);

				if (saleWorkerHelper.getAdvance() > 0) {
					workerHelperPayment = new PaymentsMaster();
					workerHelperPayment.setAmount(saleWorkerHelper.getAdvance());
					workerHelperPayment.setBillId(sales.getId());
					workerHelperPayment.setBillNo(String.valueOf(sales.getId()));
					workerHelperPayment.setTransactionDate(sales.getBookingDate());
					workerHelperPayment.setContactId(saleWorkerHelper.getContactId());
					workerHelperPayment.setPaymentMode("Cash");
					workerHelperPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					workerHelperPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					workerHelperPayment.setSystemGenerated(true);
					workerHelperPayment.setDescription("Advance Given " + saleWorkerHelper.getRole());
					paymentsService.save(workerHelperPayment);
				}
			}

			// save third party details
			List<SalesThirdParty> salesThirdPartieList = sales.getSalesThirdParties();
			for (SalesThirdParty salesThirdParty : salesThirdPartieList) {
				salesThirdParty.setSalesId(sales.getId());
				salesThirdPartyService.save(salesThirdParty);

				thirdPartyPayment = new PaymentsMaster();
				thirdPartyPayment.setAmount(salesThirdParty.getTotalAmount());
				thirdPartyPayment.setBillId(sales.getId());
				thirdPartyPayment.setBillNo(String.valueOf(sales.getId()));
				thirdPartyPayment.setTransactionDate(sales.getBookingDate());
				thirdPartyPayment.setContactId(salesThirdParty.getContactId());
				thirdPartyPayment.setPaymentMode("Cash");
				thirdPartyPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				thirdPartyPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				thirdPartyPayment.setSystemGenerated(true);
				thirdPartyPayment.setDescription("No of person :" + salesThirdParty.getNoOfPerson());
				paymentsService.save(thirdPartyPayment);

				if (salesThirdParty.getAdvance() > 0) {
					thirdPartyPayment = new PaymentsMaster();
					thirdPartyPayment.setAmount(salesThirdParty.getAdvance());
					thirdPartyPayment.setBillId(sales.getId());
					thirdPartyPayment.setBillNo(String.valueOf(sales.getId()));
					thirdPartyPayment.setTransactionDate(sales.getBookingDate());
					thirdPartyPayment.setContactId(salesThirdParty.getContactId());
					thirdPartyPayment.setPaymentMode("Cash");
					thirdPartyPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					thirdPartyPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					thirdPartyPayment.setSystemGenerated(true);
					thirdPartyPayment.setDescription("Advance Given");
					paymentsService.save(thirdPartyPayment);
				}
			}

			// save driver details
			List<SaleDriverDetails> salesDriverDetailList = sales.getSaleDriverDetails();
			for (SaleDriverDetails saleDriverDetails : salesDriverDetailList) {
				saleDriverDetails.setSalesId(sales.getId());
				saleDriverDetailsService.save(saleDriverDetails);

				driverPayment = new PaymentsMaster();
				driverPayment.setAmount(saleDriverDetails.getRate());
				driverPayment.setBillId(sales.getId());
				driverPayment.setBillNo(String.valueOf(sales.getId()));
				driverPayment.setTransactionDate(sales.getBookingDate());
				driverPayment.setContactId(saleDriverDetails.getContactId());
				driverPayment.setPaymentMode("Cash");
				driverPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				driverPayment.setSystemGenerated(true);
				driverPayment.setDescription("Vehicle No.:" + saleDriverDetails.getVehicleNo());
				paymentsService.save(driverPayment);

				if (saleDriverDetails.getAdvance() > 0) {
					driverPayment = new PaymentsMaster();
					driverPayment.setAmount(saleDriverDetails.getAdvance());
					driverPayment.setBillId(sales.getId());
					driverPayment.setBillNo(String.valueOf(sales.getId()));
					driverPayment.setTransactionDate(sales.getBookingDate());
					driverPayment.setContactId(saleDriverDetails.getContactId());
					driverPayment.setPaymentMode("Cash");
					driverPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					driverPayment.setSystemGenerated(true);
					driverPayment.setDescription("Advance Given, Vehicle No.:" + saleDriverDetails.getVehicleNo());
					paymentsService.save(driverPayment);
				}
			}
		}

		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> update(RequestData<Sales, Long> requestData) {

		Sales sales = requestData.getData();
		ResultCodeConstant resultCodeConstant = this.update(sales);

		IResponseData<Sales> responseData = new ResponseData<>(sales, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant update(Sales sales) {
		ResultCodeConstant resultCodeConstant = validateData(sales);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}

		// save purchase master
		sales.setBookingDate(DateUtils.formateDateOnly(sales.getBookingDate()));
		sales.setOrderDate(DateUtils.formateDateOnly(sales.getOrderDate()));
		sales = getRepository().update(sales);

		// save sales details
		salesDetailsService.deleteBySalesId(sales.getId());
		List<SalesDetails> salesDetailsList = sales.getSalesDetails();
		for (SalesDetails salesDetails : salesDetailsList) {
			salesDetails.setSalesId(sales.getId());
			salesDetails.setId(null);
			salesDetailsService.saveOrUpdate(salesDetails);
		}

		// delete all payment details for current saleId/ billId
		paymentsService.deleteByBillId(sales.getId(), PaymentEntryTypeConstant.SALES.getValue());

		// again insert the details
		PaymentsMaster customerPayment = new PaymentsMaster();
		customerPayment.setAmount(sales.getGrossAmount());
		customerPayment.setBillId(sales.getId());
		customerPayment.setBillNo(String.valueOf(sales.getId()));
		customerPayment.setTransactionDate(sales.getOrderDate());
		customerPayment.setContactId(sales.getContactId());
		customerPayment.setPaymentMode("Cash");
		customerPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
		customerPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
		customerPayment.setSystemGenerated(true);
		customerPayment.setDescription(SalesOrderTypeEnum.getOrderType(sales.getOrderType()).name());
		paymentsService.save(customerPayment);

		if (sales.getAdvance() > 0) {
			customerPayment = new PaymentsMaster();
			customerPayment.setAmount(sales.getAdvance());
			customerPayment.setBillId(sales.getId());
			customerPayment.setBillNo(String.valueOf(sales.getId()));
			customerPayment.setTransactionDate(sales.getOrderDate());
			customerPayment.setContactId(sales.getContactId());
			customerPayment.setPaymentMode("Cash");
			customerPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
			customerPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
			customerPayment.setSystemGenerated(true);
			customerPayment.setDescription("Advance for Bill No:" + sales.getId());
			paymentsService.save(customerPayment);
		}

		PaymentsMaster workerHelperPayment = null;
		PaymentsMaster thirdPartyPayment = null;
		PaymentsMaster driverPayment = null;

		

		if (sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue()) {
			// save address details
			Address shippingAddress = sales.getShippingAddress();
			shippingAddress.setForeinKey(sales.getId());
			shippingAddress.setModuleName(ModuleName.SALES_SHIPPING_ADDRESS.getValue());
			addressService.saveOrUpdate(shippingAddress);

			// save worker details
			saleWorkerHelperService.deleteBySaleId(sales.getId());
			List<SaleWorkerHelper> saleWorkerHelperList = sales.getSaleWorkerHelpers();
			for (SaleWorkerHelper saleWorkerHelper : saleWorkerHelperList) {
				saleWorkerHelper.setSalesId(sales.getId());
				saleWorkerHelper.setId(null);
				saleWorkerHelperService.saveOrUpdate(saleWorkerHelper);

				workerHelperPayment = new PaymentsMaster();
				workerHelperPayment.setAmount(saleWorkerHelper.getRate());
				workerHelperPayment.setBillId(sales.getId());
				workerHelperPayment.setBillNo(String.valueOf(sales.getId()));
				workerHelperPayment.setTransactionDate(sales.getBookingDate());
				workerHelperPayment.setContactId(saleWorkerHelper.getContactId());
				workerHelperPayment.setPaymentMode("Cash");
				workerHelperPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				workerHelperPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				workerHelperPayment.setSystemGenerated(true);
				workerHelperPayment.setDescription(saleWorkerHelper.getRole());
				paymentsService.save(workerHelperPayment);

				if (saleWorkerHelper.getAdvance() > 0) {
					workerHelperPayment = new PaymentsMaster();
					workerHelperPayment.setAmount(saleWorkerHelper.getAdvance());
					workerHelperPayment.setBillId(sales.getId());
					workerHelperPayment.setBillNo(String.valueOf(sales.getId()));
					workerHelperPayment.setTransactionDate(sales.getBookingDate());
					workerHelperPayment.setContactId(saleWorkerHelper.getContactId());
					workerHelperPayment.setPaymentMode("Cash");
					workerHelperPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					workerHelperPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					workerHelperPayment.setSystemGenerated(true);
					workerHelperPayment.setDescription("Advance Given " + saleWorkerHelper.getRole());
					paymentsService.save(workerHelperPayment);
				}
			}

			// save third party details
			salesThirdPartyService.deleteBySaleId(sales.getId());
			List<SalesThirdParty> salesThirdPartieList = sales.getSalesThirdParties();
			for (SalesThirdParty salesThirdParty : salesThirdPartieList) {
				salesThirdParty.setSalesId(sales.getId());
				salesThirdParty.setId(null);
				salesThirdPartyService.saveOrUpdate(salesThirdParty);

				thirdPartyPayment = new PaymentsMaster();
				thirdPartyPayment.setAmount(salesThirdParty.getTotalAmount());
				thirdPartyPayment.setBillId(sales.getId());
				thirdPartyPayment.setBillNo(String.valueOf(sales.getId()));
				thirdPartyPayment.setTransactionDate(sales.getBookingDate());
				thirdPartyPayment.setContactId(salesThirdParty.getContactId());
				thirdPartyPayment.setPaymentMode("Cash");
				thirdPartyPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				thirdPartyPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				thirdPartyPayment.setSystemGenerated(true);
				thirdPartyPayment.setDescription("No of person :" + salesThirdParty.getNoOfPerson());
				paymentsService.save(thirdPartyPayment);

				if (salesThirdParty.getAdvance() > 0) {
					thirdPartyPayment = new PaymentsMaster();
					thirdPartyPayment.setAmount(salesThirdParty.getAdvance());
					thirdPartyPayment.setBillId(sales.getId());
					thirdPartyPayment.setBillNo(String.valueOf(sales.getId()));
					thirdPartyPayment.setTransactionDate(sales.getBookingDate());
					thirdPartyPayment.setContactId(salesThirdParty.getContactId());
					thirdPartyPayment.setPaymentMode("Cash");
					thirdPartyPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					thirdPartyPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					thirdPartyPayment.setSystemGenerated(true);
					thirdPartyPayment.setDescription("Advance Given");
					paymentsService.save(thirdPartyPayment);
				}
			}

		}
		if ((sales.getOrderType() == SalesOrderTypeEnum.WHOLE_SALE_ORDER.getValue()) ||(sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue())) {
			// save driver details
			saleDriverDetailsService.deleteBySaleId(sales.getId());
			List<SaleDriverDetails> salesDriverDetailList = sales.getSaleDriverDetails();
			for (SaleDriverDetails saleDriverDetails : salesDriverDetailList) {
				saleDriverDetails.setId(null);
				saleDriverDetails.setSalesId(sales.getId());
				saleDriverDetailsService.saveOrUpdate(saleDriverDetails);

				driverPayment = new PaymentsMaster();
				driverPayment.setAmount(saleDriverDetails.getRate());
				driverPayment.setBillId(sales.getId());
				driverPayment.setBillNo(String.valueOf(sales.getId()));
				driverPayment.setTransactionDate(sales.getBookingDate());
				driverPayment.setContactId(saleDriverDetails.getContactId());
				driverPayment.setPaymentMode("Cash");
				driverPayment.setCreditDebitFlag(PaymentConstant.CREDIT.getValue());
				driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
				driverPayment.setSystemGenerated(true);
				driverPayment.setDescription("Vehicle No.:" + saleDriverDetails.getVehicleNo());
				paymentsService.save(driverPayment);

				if (saleDriverDetails.getAdvance() > 0) {
					driverPayment = new PaymentsMaster();
					driverPayment.setAmount(saleDriverDetails.getAdvance());
					driverPayment.setBillId(sales.getId());
					driverPayment.setBillNo(String.valueOf(sales.getId()));
					driverPayment.setTransactionDate(sales.getBookingDate());
					driverPayment.setContactId(saleDriverDetails.getContactId());
					driverPayment.setPaymentMode("Cash");
					driverPayment.setCreditDebitFlag(PaymentConstant.DEBIT.getValue());
					driverPayment.setEntryType(PaymentEntryTypeConstant.SALES.getValue());
					driverPayment.setSystemGenerated(true);
					driverPayment.setDescription("Advance Given, Vehicle No.:" + saleDriverDetails.getVehicleNo());
					paymentsService.save(driverPayment);
				}
			}

		}
		

		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> saveOrUpdate(RequestData<Sales, Long> requestData) {
		ResultCodeConstant resultCodeConstant = validateData(requestData.getData());
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<Sales> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		IResponseData<Sales> responseData = new ResponseData<>(getRepository().saveOrUpdate(requestData.getData()),
				ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant saveOrUpdate(Sales sales) {
		ResultCodeConstant resultCodeConstant = validateData(sales);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}

		if (sales.getId() == null) {
			return this.save(sales);
		}
		return this.update(sales);
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> saveOrUpdateAll(RequestData<Sales, Long> requestData) {
		// check if list is empty then return the result code with empty list message
		List<Sales> salesList = requestData.getDataList();
		if (salesList == null || salesList.isEmpty()) {
			IResponseData<Sales> responseData = new ResponseData<>(requestData.getDataList(),
					ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}

		// save the data list
		IResponseData<Sales> responseData = new ResponseData<>(
				getRepository().saveOrUpdateAll(requestData.getDataList().iterator()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> getById(RequestData<Sales, Long> requestData) {
		if (requestData.getId() == null) {
			IResponseData<Sales> responseData = new ResponseData<>(requestData.getData(),
					ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		Sales sales = getRepository().getById(requestData.getId());

		SalesInitData salesInitData = new SalesInitData();
		sales.setSalesInitData(salesInitData);
		AddressDataList addressDataList = new AddressDataList();
		salesInitData.setAddressDataList(addressDataList);

		RequestData<SearchData<Contact>, Long> contactReqData = new RequestData<>();
		SearchData<Contact> contactSearchData = new SearchData<>();
		contactReqData.setData(contactSearchData);
		ContactTypeDataList contactTypeDataList = new ContactTypeDataList();

		// sales details
		sales.setSalesDetails(salesDetailsService.getBySalesId(sales.getId()));

		RequestData<SearchData<Item>, Long> itemReqData = new RequestData<>();
		SearchData<Item> itemSearchData = new SearchData<>();
		itemReqData.setData(itemSearchData);

		if (sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue()) {

			contactTypeDataList.setCustomerContactList(
					contactService.getCustomer(contactReqData).getBody().getData().getContactList());
			contactTypeDataList.setWorkerHelperContactList(
					contactService.getWorkerHelper(contactReqData).getBody().getData().getContactList());
			contactTypeDataList.setThirdPartyContactList(
					contactService.getThirdParty(contactReqData).getBody().getData().getContactList());
			contactTypeDataList.setDriverContactList(
					contactService.getDriver(contactReqData).getBody().getData().getContactList());

			salesInitData.setItemList(itemService.getLiveFoodListData(itemReqData).getBody().getDataList());

			// country list
			RequestData<SearchData<Country>, Long> countryReqData = new RequestData<>();
			SearchData<Country> countrySearchData = new SearchData<>();
			countryReqData.setData(countrySearchData);
			addressDataList.setCountryList(countryService.getActiveData(countryReqData).getBody().getDataList());

			// set state list
			RequestData<SearchData<State>, Long> stateReqData = new RequestData<>();
			SearchData<State> stateSearchData = new SearchData<>();
			stateReqData.setData(stateSearchData);
			addressDataList.setStateList(stateService.getActiveData(stateReqData).getBody().getDataList());

			// city list
			RequestData<SearchData<City>, Long> cityReqData = new RequestData<>();
			SearchData<City> citySearchData = new SearchData<>();
			cityReqData.setData(citySearchData);
			addressDataList.setCityList(cityService.getActiveData(cityReqData).getBody().getDataList());

			// address details
			Address billinAddress = new Address();
			billinAddress.setModuleName(ModuleName.SALES_SHIPPING_ADDRESS.getValue());
			billinAddress.setForeinKey(sales.getId());
			sales.setShippingAddress(addressService.getAddressByForeignKeyId(billinAddress));

			// sales worker-helper details
			sales.setSaleWorkerHelpers(saleWorkerHelperService.getBySalesId(sales.getId()));

			// sales third party details
			sales.setSalesThirdParties(salesThirdPartyService.getBySalesId(sales.getId()));

			// sales driver details
			sales.setSaleDriverDetails(saleDriverDetailsService.getBySalesId(sales.getId()));
		} else if (sales.getOrderType() == SalesOrderTypeEnum.WHOLE_SALE_ORDER.getValue()) {
			contactTypeDataList.setCustomerContactList(
					contactService.getCustomer(contactReqData).getBody().getData().getContactList());
			sales.setSaleDriverDetails(saleDriverDetailsService.getBySalesId(sales.getId()));
			salesInitData.setItemList(itemService.getWholeSaleListData(itemReqData).getBody().getDataList());
		} else if (sales.getOrderType() == SalesOrderTypeEnum.DAILY_ORDER.getValue()) {
			salesInitData.setItemList(itemService.getDailyFoodCounterListData(itemReqData).getBody().getDataList());
		} else {
			salesInitData.setItemList(itemService.getActiveData(itemReqData).getBody().getDataList());
		}

		salesInitData.setContacts(contactTypeDataList);
		sales.setDefaultValueForObject();
		IResponseData<Sales> responseData = new ResponseData<>(sales, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public Sales getById(Sales sales) {
		sales = getRepository().getById(sales.getId());
		
		if (sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue()) {
			Address billinAddress = new Address();
			billinAddress.setModuleName(ModuleName.SALES_SHIPPING_ADDRESS.getValue());
			billinAddress.setForeinKey(sales.getId());
			sales.setShippingAddress(addressService.getAddressByForeignKeyId(billinAddress));
		}
		
		// sales details
		sales.setSalesDetails(salesDetailsService.getBySalesId(sales.getId()));
		sales.setContact(contactService.getById(sales.getContactId()));
		sales.setDefaultValueForObject();

		// sales item details
		sales.setSalesDetails(salesDetailsService.getBySalesId(sales.getId()));

		// sales worker-helper details
		sales.setSaleWorkerHelpers(saleWorkerHelperService.getBySalesId(sales.getId()));

		// sales third party details
		sales.setSalesThirdParties(salesThirdPartyService.getBySalesId(sales.getId()));

		// sales driver details
		sales.setSaleDriverDetails(saleDriverDetailsService.getBySalesId(sales.getId()));
		return sales;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> getActiveData(RequestData<SearchData<Sales>, Long> requestData) {
		/*
		 * Map<String, Object> params = new HashMap<>(); params.put("orderType", rq);
		 * params.put("deleted", false); return getRepository().getByQueryData(params,
		 * Collections.emptyMap());
		 */

		ResponseEntity<IResponseData<Sales>> responseEntity = super.getActiveData(requestData);
		List<Sales> salesList = responseEntity.getBody().getDataList();

		for (Sales sales : salesList) {
			sales.setContact(contactService.getById(sales.getContactId()));
		}

		return responseEntity;
	}

	@Override
	public ResponseEntity<IResponseData<Sales>> delete(RequestData<Sales, Long> requestData) {
		ResponseEntity<IResponseData<Sales>> responseEntity = super.delete(requestData);

		Sales sales = requestData.getData();
		sales = this.getById(sales);

		// delete item details
		salesDetailsService.deleteBySalesId(sales.getId());

		// delete customer and advance details
		paymentsService.deleteByBillId(sales.getId(), PaymentEntryTypeConstant.SALES.getValue());

		return responseEntity;
	}

}