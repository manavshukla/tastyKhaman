package com.aone.module.contactPayTerms.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactPayTerms.controller.IContactPayTermsController;
import com.aone.module.contactPayTerms.model.ContactPayTerms;
import com.aone.module.contactPayTerms.service.IContactPayTermsService;

@RestController
@RequestMapping("/rest/contactPayTerms")
public class ContactPayTermsRestController extends AbstractBaseMasterRestController<ContactPayTerms, Long, IContactPayTermsService> implements IContactPayTermsController {
	
	private IContactPayTermsService contactPayTermsService;
	
	@Override
	public IContactPayTermsService getService() {
		return getContactPayTermsService();
	}

	public IContactPayTermsService getContactPayTermsService() {
		return contactPayTermsService;
	}

	@Autowired        
	@Qualifier(value="contactPayTermsServiceImpl")
	public void setContactPayTermsService(IContactPayTermsService contactPayTermsService) {
		this.contactPayTermsService = contactPayTermsService;
	}

}
