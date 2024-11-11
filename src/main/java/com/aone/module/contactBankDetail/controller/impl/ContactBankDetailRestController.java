package com.aone.module.contactBankDetail.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactBankDetail.controller.IContactBankDetailController;
import com.aone.module.contactBankDetail.model.ContactBankDetail;
import com.aone.module.contactBankDetail.service.IContactBankDetailService;

@RestController
@RequestMapping("/rest/contactBankDetail")public class ContactBankDetailRestController extends AbstractBaseMasterRestController<ContactBankDetail , Long, IContactBankDetailService > implements IContactBankDetailController  {

	private IContactBankDetailService contactBankDetailService;
	
	@Override
	public IContactBankDetailService getService() {
		return getContactBankDetailService();
	}

	public IContactBankDetailService getContactBankDetailService() {
		return contactBankDetailService;
	}

	@Autowired
	@Qualifier(value="contactBankDetailServiceImpl")
	public void setContcontactBankDetailServiceactBankDetailService(IContactBankDetailService contactBankDetailService) {
		this.contactBankDetailService = contactBankDetailService;
	}

}
