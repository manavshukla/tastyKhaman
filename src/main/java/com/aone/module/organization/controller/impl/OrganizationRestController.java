package com.aone.module.organization.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.organization.controller.IOrganizationController;
import com.aone.module.organization.model.Organization;
import com.aone.module.organization.service.IOrganizationService;

@RestController
@RequestMapping("/rest/organization")
public class OrganizationRestController extends AbstractBaseMasterRestController<Organization, Long, IOrganizationService> implements IOrganizationController {
	
	private IOrganizationService organizationService;
	
	@Override
	public IOrganizationService getService() {
		return getOrganizationService();
	}

	public IOrganizationService getOrganizationService() {
		return organizationService;
	}

	@Autowired        
	@Qualifier(value="organizationServiceImpl")
	public void setOrganizationService(IOrganizationService organizationService) {
		this.organizationService = organizationService;
	}
}
