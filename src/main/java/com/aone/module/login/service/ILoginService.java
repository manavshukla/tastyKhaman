package com.aone.module.login.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.contact.model.Contact;

public interface ILoginService {

	public Contact getCurrentLoginUserDetails();
	
	public ResponseEntity<IResponseData<Contact>> getCurrentLoginUserDetails(RequestData<Contact, Long> requestData);

	public boolean checkIfHasPermission(String moduleName, String permisson);
	
	public String getCurrentLoginUserName();

}
