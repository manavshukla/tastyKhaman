package com.aone.module.contactWiseItemRate.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactWiseItemRate.controller.IContactWiseItemRateController;
import com.aone.module.contactWiseItemRate.model.ContactWiseItemRate;
import com.aone.module.contactWiseItemRate.service.IContactWiseItemRateService;

@RestController
@RequestMapping("/rest/contactWiseItemRate")
public class ContactWiseItemRateRestController extends AbstractBaseMasterRestController<ContactWiseItemRate , Long, IContactWiseItemRateService> implements IContactWiseItemRateController {
	
	private IContactWiseItemRateService contactWiseItemRateService;
	
	@Override
	public IContactWiseItemRateService getService() {
		return getContactWiseItemRateService();
	}

	public IContactWiseItemRateService getContactWiseItemRateService() {
		return contactWiseItemRateService;
	}

	@Autowired        
	@Qualifier(value="contactWiseItemRateServiceImpl")
	public void setContactWiseItemRateService(IContactWiseItemRateService contactWiseItemRateService) {
		this.contactWiseItemRateService = contactWiseItemRateService;
	}

}
