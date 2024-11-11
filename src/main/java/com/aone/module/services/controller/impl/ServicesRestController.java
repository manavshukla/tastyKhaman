package com.aone.module.services.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.services.controller.IServicesController;
import com.aone.module.services.model.Services;
import com.aone.module.services.service.IServicesService;

@RestController
@RequestMapping("/rest/servicesMaster")
@SecurityClassRole(baseRoleName = SecurityRoleModule.SERVICES)
public class ServicesRestController extends AbstractBaseMasterRestController<Services, Long, IServicesService> implements IServicesController{
	
	private IServicesService servicesService;
	
	@Override
	public IServicesService getService() {
		return getServicesService();
	}

	public IServicesService getServicesService() {
		return servicesService;
	}

	@Autowired        
	@Qualifier(value="servicesServiceImpl")
	public void setServicesService(IServicesService servicesService) {
		this.servicesService = servicesService;
	}
}
