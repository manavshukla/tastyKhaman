package com.aone.module.organizationPaymentTerms.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.organizationPaymentTerms.controller.IOrganizationPaymentTermsController;
import com.aone.module.organizationPaymentTerms.model.OrganizationPaymentTerms;
import com.aone.module.organizationPaymentTerms.service.IOrganizationPaymentTermsService;

@RestController
@RequestMapping("/rest/organizationPaymentTerms")
public class OrganizationPaymentTermsRestController extends AbstractBaseMasterRestController<OrganizationPaymentTerms, Long, IOrganizationPaymentTermsService> implements IOrganizationPaymentTermsController {

	private IOrganizationPaymentTermsService organizationPaymentTermsService;
	
	@Override
	public IOrganizationPaymentTermsService getService() {
		return getOrganizationPaymentTermsService();
	}

	public IOrganizationPaymentTermsService getOrganizationPaymentTermsService() {
		return organizationPaymentTermsService;
	}

	@Autowired
	@Qualifier(value="organizationPaymentTermsServiceImpl")
	public void setOrganizationPaymentTermsService(
			IOrganizationPaymentTermsService organizationPaymentTermsService) {
		this.organizationPaymentTermsService = organizationPaymentTermsService;
	}

}
