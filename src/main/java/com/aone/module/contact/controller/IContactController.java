package com.aone.module.contact.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactListData;

public interface IContactController extends IBaseMasterController<Contact, Long>{
	
	public ResponseEntity<IResponseData<ContactListData>> getContactListData(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getCustomer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getDriver(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getRetailer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getThirdParty(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getVendorDealer(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getWorkerHelper(RequestData<SearchData<Contact>, Long> requestData);

	public ResponseEntity<IResponseData<ContactListData>> getOther(RequestData<SearchData<Contact>, Long> requestData);

}
