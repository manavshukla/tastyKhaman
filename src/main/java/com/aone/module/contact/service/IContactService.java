package com.aone.module.contact.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactListData;
import com.aone.module.contactCategory.constant.ContactCategoryConstant;

public interface IContactService  extends IBaseMasterService<Contact, Long>{
	
	public ResponseEntity<IResponseData<ContactListData>> getContactListData(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getContactListData(RequestData<SearchData<Contact>, Long> requestData, ContactCategoryConstant contactCategoryConstant);

	public ResponseEntity<IResponseData<ContactListData>> getCustomer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getDriver(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getRetailer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getThirdParty(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getVendorDealer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getWorkerHelper(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getOther(RequestData<SearchData<Contact>, Long> requestData);
	
	public Contact getByUserName(String userName);

}
