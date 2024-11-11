package com.aone.module.servicescategory.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.servicescategory.controller.IServicesCategoryController;
import com.aone.module.servicescategory.model.ServicesCategory;
import com.aone.module.servicescategory.service.IServicesCategoryService;

@RestController
@RequestMapping("/rest/servicesCategory")
@SecurityClassRole(baseRoleName = SecurityRoleModule.SERVICES_CATEGORY)
public class ServicesCategoryRestController extends AbstractBaseMasterRestController<ServicesCategory, Long, IServicesCategoryService> implements IServicesCategoryController {

	private IServicesCategoryService servicesCategoryService; 
	
	@Override
	public IServicesCategoryService getService() {
		return getServicesCategoryService();
	}

	public IServicesCategoryService getServicesCategoryService() {
		return servicesCategoryService;
	}

	@Autowired
	@Qualifier(value="servicesCategoryServiceImpl")
	public void setServicesCategoryService(IServicesCategoryService servicesCategoryService) {
		this.servicesCategoryService = servicesCategoryService;
	}
}
