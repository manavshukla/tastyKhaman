package com.aone.module.contactPerson.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactPerson.controller.IContactPersonController;
import com.aone.module.contactPerson.model.ContactPerson;
import com.aone.module.contactPerson.service.IContactPersonService;

@RestController
@RequestMapping("/rest/contactPerson")
public class ContactPersonRestController extends AbstractBaseMasterRestController<ContactPerson, Long, IContactPersonService>
		implements IContactPersonController {
	
	private IContactPersonService contactPersonService;
	
	@Override
	public IContactPersonService getService() {
		return getContactPersonService();
	}
	
	public IContactPersonService getContactPersonService() {
		return contactPersonService;
	}

	@Autowired        
	@Qualifier(value="contactPersonServiceImpl")
	public void setContactPersonService(IContactPersonService contactPersonService) {
		this.contactPersonService = contactPersonService;
	}

}
