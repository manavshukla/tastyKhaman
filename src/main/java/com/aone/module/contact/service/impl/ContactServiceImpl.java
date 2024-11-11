package com.aone.module.contact.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.commons.ModuleName;
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
import com.aone.module.contact.dao.IContactDao;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactInitData;
import com.aone.module.contact.model.ContactListData;
import com.aone.module.contact.service.IContactService;
import com.aone.module.contactBankDetail.service.IContactBankDetailService;
import com.aone.module.contactCategory.constant.ContactCategoryConstant;
import com.aone.module.contactCategory.model.ContactCategory;
import com.aone.module.contactCategory.service.IContactCategoryService;
import com.aone.module.contactOtherDetail.service.IContactOtherDetailService;
import com.aone.module.contactPerson.service.IContactPersonService;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;
import com.aone.module.state.model.State;
import com.aone.module.state.service.IStateService;
import com.aone.module.userRoleGroup.model.UserRoleGroup;
import com.aone.module.userRoleGroup.service.IUserRoleGroupService;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;
import com.aone.module.userRoleGroupMapping.service.IUserRoleGroupMappingService;

@Lazy
@Service("contactServiceImpl")
public class ContactServiceImpl extends AbstractBaseMasterService<Contact, Long, IContactDao>
		implements IContactService {

	private IContactDao contactDao;
	private IAddressService addressService;
	private IContactOtherDetailService contactOtherDetailService;
	private IContactBankDetailService contactBankDetailService;
	private IContactPersonService contactPersonService;
	private ICountryService countryService;
	private IStateService stateService;
	private ICityService cityService;
	private IContactCategoryService contactCategoryService;
	private IUserRoleGroupMappingService userRoleGroupMappingService;
	private IUserRoleGroupService userRoleGroupService;

	public IUserRoleGroupMappingService getUserRoleGroupMappingService() {
		return userRoleGroupMappingService;
	}

	@Autowired
	@Qualifier(value = "userRoleGroupMappingServiceImpl")
	public void setUserRoleGroupMappingService(IUserRoleGroupMappingService userRoleGroupMappingService) {
		this.userRoleGroupMappingService = userRoleGroupMappingService;
	}

	public IUserRoleGroupService getUserRoleGroupService() {
		return userRoleGroupService;
	}

	@Autowired
	@Qualifier(value = "userRoleGroupServiceImpl")
	public void setUserRoleGroupService(IUserRoleGroupService userRoleGroupService) {
		this.userRoleGroupService = userRoleGroupService;
	}

	public IContactCategoryService getContactCategoryService() {
		return contactCategoryService;
	}

	@Autowired
	@Qualifier(value = "contactCategoryServiceImpl")
	public void setContactCategoryService(IContactCategoryService contactCategoryService) {
		this.contactCategoryService = contactCategoryService;
	}

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

	@Override
	public IContactDao getRepository() {
		return getContactDao();
	}

	public IContactDao getContactDao() {
		return contactDao;
	}

	@Autowired
	@Qualifier(value = "contactDaoImpl")
	public void setContactDao(IContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public IAddressService getAddressService() {
		return addressService;
	}

	@Autowired
	@Qualifier(value = "addressServiceImpl")
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	public IContactOtherDetailService getContactOtherDetailService() {
		return contactOtherDetailService;
	}

	@Autowired
	@Qualifier(value = "contactOtherDetailServiceImpl")
	public void setContactOtherDetailService(IContactOtherDetailService contactOtherDetailService) {
		this.contactOtherDetailService = contactOtherDetailService;
	}

	public IContactBankDetailService getContactBankDetailService() {
		return contactBankDetailService;
	}

	@Autowired
	@Qualifier(value = "contactBankDetailServiceImpl")
	public void setContactBankDetailService(IContactBankDetailService contactBankDetailService) {
		this.contactBankDetailService = contactBankDetailService;
	}

	public IContactPersonService getContactPersonService() {
		return contactPersonService;
	}

	@Autowired
	@Qualifier(value = "contactPersonServiceImpl")
	public void setContactPersonService(IContactPersonService contactPersonService) {
		this.contactPersonService = contactPersonService;
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> save(RequestData<Contact, Long> requestData) {
		Contact contact = requestData.getData();

		// validate contact data
		ResultCodeConstant resultCodeConstant = validateData(contact);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<Contact> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}

		if (contact.getLname() == null) {
			contact.setLname(StringUtils.EMPTY);
		}

		// save contact detail first
		contact = getRepository().save(contact);

		// save user role group mapping
		List<UserRoleGroupMapping> userRoleGroupMappingList = contact.getUserRoleGroupMappingList();
		if (userRoleGroupMappingList != null) {
			for (UserRoleGroupMapping userRoleGroupMapping : userRoleGroupMappingList) {
				userRoleGroupMapping.setContactId(contact.getId());
				userRoleGroupMappingService.save(userRoleGroupMapping);
			}
		}

		// save billing address
		Address billingAddress = contact.getBillingAddress();
		if (billingAddress != null) {
			billingAddress.setForeinKey(contact.getId());
			billingAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
			addressService.save(billingAddress);
		}
		// return the response object to client
		IResponseData<Contact> responseData = new ResponseData<>(contact, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> update(RequestData<Contact, Long> requestData) {
		Contact contact = requestData.getData();

		// validate contact data
		ResultCodeConstant resultCodeConstant = validateData(contact);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<Contact> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}

		if (contact.getLname() == null) {
			contact.setLname(StringUtils.EMPTY);
		}

		// save contact detail first
		contact = getRepository().update(contact);

		// save billing address
		Address billingAddress = contact.getBillingAddress();
		if (billingAddress != null) {
			billingAddress.setForeinKey(contact.getId());
			billingAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
			addressService.update(billingAddress);
		}

		// delete user role group mapping
		userRoleGroupMappingService.deleteByContactId(contact.getId());
		// save user role group mapping
		List<UserRoleGroupMapping> userRoleGroupMappingList = contact.getUserRoleGroupMappingList();
		if (userRoleGroupMappingList != null) {
			for (UserRoleGroupMapping userRoleGroupMapping : userRoleGroupMappingList) {
				userRoleGroupMapping.setContactId(contact.getId());
				userRoleGroupMappingService.save(userRoleGroupMapping);
			}
		}
		// return the response object to client
		IResponseData<Contact> responseData = new ResponseData<>(contact, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> saveOrUpdate(RequestData<Contact, Long> requestData) {
		Contact contact = requestData.getData();

		if (contact.getId() != null && contact.getId() > 0) {
			return this.update(requestData);
		}
		return this.save(requestData);
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> saveOrUpdateAll(RequestData<Contact, Long> requestData) {
		List<Contact> contactsList = requestData.getDataList();

		if (contactsList == null || contactsList.isEmpty()) {
			IResponseData<Contact> responseData = new ResponseData<>(requestData.getData(),
					ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}

		for (Contact contact : contactsList) {
			if (this.saveOrUpdate(contact) == null) {
				IResponseData<Contact> responseData = new ResponseData<>(requestData.getData(),
						ResultCodeConstant.INTERNAL_ERROR);
				responseData.setRequestToken(requestData.getRequestToken());
				return new ResponseEntity<>(responseData, HttpStatus.OK);
			}
		}

		// return the response object to client
		IResponseData<Contact> responseData = new ResponseData<>(contactsList, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> getActiveData(RequestData<SearchData<Contact>, Long> requestData) {
		List<Contact> contactList = contactDao.getActiveData(requestData.getData());

		// billing address references
		Address billinAddress = new Address();
		billinAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());

		for (Contact contact : contactList) {
			// setting contact address details
			billinAddress.setForeinKey(contact.getId());
			contact.setBillingAddress(addressService.getAddressByForeignKeyId(billinAddress));

			// set contct category
			contact.setContactCategory(contactCategoryService.getById(contact.getContactCategoryId()));
		}

		IResponseData<Contact> responseData = new ResponseData<>(contactList, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		responseData.setTotalRecords(getRepository().getActiveDataCount(requestData.getData()));
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Contact>> getById(RequestData<Contact, Long> requestData) {
		Contact contact = contactDao.getById(requestData.getId());

		// setting user role group mapping
		contact.setUserRoleGroupMappingList(userRoleGroupMappingService.getByContactId(contact.getId()));

		ContactInitData contactInitData = new ContactInitData();		
		contact.setContactInitData(contactInitData);
		
		// fetching user role groups list
		SearchData<UserRoleGroup> userRoleSearchData = new SearchData<UserRoleGroup>();
		List<UserRoleGroup> userRoleGroupList = userRoleGroupService.getActiveData(userRoleSearchData);
		contactInitData.setUserRoleGroupList(userRoleGroupList);
		
		AddressDataList addressDataList = new AddressDataList();
		contactInitData.setAddressDataList(addressDataList);
		
		// country list
		SearchData<Country> countrySearchData = new SearchData<>();
		addressDataList.setCountryList(countryService.getActiveData(countrySearchData));

		// fetch state list
		SearchData<State> stateSearchData = new SearchData<>();
		State state = new State();
		List<State> stateList = null;

		// fetch state list
		SearchData<City> citySearchData = new SearchData<>();
		City city = new City();
		List<City> cityList = null;

		// cconatct Category
		SearchData<ContactCategory> contactCategorySearchData = new SearchData<>();
		contactInitData.setContactCategoryList(contactCategoryService.getActiveData(contactCategorySearchData));

		// setting billing address details
		Address billinAddress = new Address();
		billinAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
		billinAddress.setForeinKey(contact.getId());
		contact.setBillingAddress(addressService.getAddressByForeignKeyId(billinAddress));

		if (contact.getBillingAddress() != null) {
			if (contact.getBillingAddress().getCountryId() > 0) {
				state.setCountryId(contact.getBillingAddress().getCountryId());
				stateSearchData.setData(state);
				stateList = stateService.getByCountryId(contact.getBillingAddress().getCountryId());
			}
			if (contact.getBillingAddress().getStateId() > 0) {
				city.setStateId(contact.getBillingAddress().getStateId());
				citySearchData.setData(city);
				cityList = cityService.getByStateId(contact.getBillingAddress().getStateId());
			}
		}
		addressDataList.setStateList(stateList);
		addressDataList.setCityList(cityList);

		IResponseData<Contact> responseData = new ResponseData<>(contact, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant save(Contact contact) {
		ResultCodeConstant resultCodeConstant = validateData(contact);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		contact = getRepository().save(contact);

		// save billing address
		Address billingAddress = contact.getBillingAddress();
		if (billingAddress != null) {
			billingAddress.setForeinKey(contact.getId());
			billingAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
			addressService.save(billingAddress);
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResultCodeConstant update(Contact contact) {
		ResultCodeConstant resultCodeConstant = validateData(contact);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		// save contact details
		contact = getRepository().update(contact);

		// save billing address
		Address billingAddress = contact.getBillingAddress();
		if (billingAddress != null) {
			billingAddress.setForeinKey(contact.getId());
			billingAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
			addressService.update(billingAddress);
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResultCodeConstant saveOrUpdate(Contact contact) {
		if (contact.getId() != null && contact.getId() > 0) {
			return this.update(contact);
		}
		return this.save(contact);
	}

	@Override
	public List<Contact> saveOrUpdateAll(List<Contact> contactList) {
		// check if list is empty then return the result code with empty list message
		if (contactList == null || contactList.isEmpty()) {
			return null;
		}

		// validate all the data
		for (Contact data : contactList) {
			ResultCodeConstant resultCodeConstant = validateData(data);
			if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
				return null;
			}
		}

		// save the data list
		Iterator<Contact> iterator = contactList.iterator();
		List<Contact> result = new ArrayList<>();
		while (iterator.hasNext()) {
			Contact entity = iterator.next();

			if (entity.getId() == null) {
				this.save(entity);
			} else {
				this.update(entity);
			}
			result.add(entity);
		}
		return result;
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getCustomer(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.CUSTOMER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getDriver(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.DRIVER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getRetailer(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.RETAILER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getThirdParty(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.THIRD_PARTY);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getVendorDealer(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.VENDOR_DEALER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getWorkerHelper(
			RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.WORKER_HELPER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getOther(RequestData<SearchData<Contact>, Long> requestData) {
		return getContactListData(requestData, ContactCategoryConstant.OTHER);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getContactListData(
			RequestData<SearchData<Contact>, Long> requestData, ContactCategoryConstant contactCategoryConstant) {

		SearchData<Contact> searchData = requestData.getData();

		List<Contact> contactList = null;
		if (ContactCategoryConstant.CUSTOMER != contactCategoryConstant) {
			long contactCategoryId = 0;

			List<ContactCategory> contactCategoryList = contactCategoryService.getByFieldName("name",
					contactCategoryConstant.getValue());
			if (contactCategoryList != null && !contactCategoryList.isEmpty()) {
				contactCategoryId = contactCategoryList.get(0).getId();
			}

			contactList = contactDao.getListByCategory(contactCategoryId);
		} else {
			contactList = contactDao.getActiveData(searchData);
		}

		if (ContactCategoryConstant.CUSTOMER == contactCategoryConstant) {
			Address billinAddress = null;
			for (Contact tempContact : contactList) {
				// setting billing address details
				billinAddress = new Address();
				billinAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
				billinAddress.setForeinKey(tempContact.getId());
				tempContact.setBillingAddress(addressService.getAddressByForeignKeyId(billinAddress));
				if (tempContact.getBillingAddress() == null) {
					tempContact.setBillingAddress(new Address());
				}
			}
		}

		ContactListData contactListData = new ContactListData();
		contactListData.setContactList(contactList);

		IResponseData<ContactListData> responseData = new ResponseData<>(contactListData, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<ContactListData>> getContactListData(
			RequestData<SearchData<Contact>, Long> requestData) {

		SearchData<Contact> searchData = requestData.getData();

		Contact contact = searchData.getData();

		List<Contact> contactList = contactDao.getListByCategory(contact.getContactCategoryId());

		ContactListData contactListData = new ContactListData();
		contactListData.setContactList(contactList);

		IResponseData<ContactListData> responseData = new ResponseData<>(contactListData, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	public Contact getContactById(Long id) {
		Contact contact = contactDao.getById(id);
		return contact;
	}

	@Override
	public Contact getByUserName(String userName) {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", userName);
		params.put("deleted", false);
		List<Contact> contactList = getRepository().getByQueryData(params, Collections.emptyMap());
		if (contactList == null || contactList.isEmpty()) {
			return null;
		}
		return contactList.get(0);
	}
}
