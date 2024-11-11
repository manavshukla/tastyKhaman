package com.aone.module.contactOtherDetail.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactOtherDetail.controller.IContactOtherDetailController;
import com.aone.module.contactOtherDetail.model.ContactOtherDetail;
import com.aone.module.contactOtherDetail.service.IContactOtherDetailService;

@RestController
@RequestMapping("/rest/contactOtherDetail")
public class ContactOtherDetailRestController extends AbstractBaseMasterRestController<ContactOtherDetail  , Long, IContactOtherDetailService  > implements IContactOtherDetailController   {

	private IContactOtherDetailService  contactOtherDetailService;
	
	@Override
	public IContactOtherDetailService getService() {
		return getContactOtherDetailService();
	}

	public IContactOtherDetailService getContactOtherDetailService() {
		return contactOtherDetailService;
	}

	@Autowired
	@Qualifier(value="contactOtherDetailServiceImpl")
	public void setContactOtherDetailService(IContactOtherDetailService contactOtherDetailService) {
		this.contactOtherDetailService = contactOtherDetailService;
	}

}
