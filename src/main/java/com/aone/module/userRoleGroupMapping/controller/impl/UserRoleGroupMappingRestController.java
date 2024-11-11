package com.aone.module.userRoleGroupMapping.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.userRoleGroupMapping.controller.IUserRoleGroupMappingController;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;
import com.aone.module.userRoleGroupMapping.service.IUserRoleGroupMappingService;

@RestController
@RequestMapping("/rest/userRoleGroupMapping")
public class UserRoleGroupMappingRestController extends AbstractBaseMasterRestController<UserRoleGroupMapping , Long, IUserRoleGroupMappingService> implements IUserRoleGroupMappingController {
	
	private IUserRoleGroupMappingService userRoleGroupMappingService;
	
	@Override
	public IUserRoleGroupMappingService getService() {
		return getUserRoleGroupMappingService();
	}

	public IUserRoleGroupMappingService getUserRoleGroupMappingService() {
		return userRoleGroupMappingService;
	}

	@Autowired        
	@Qualifier(value="userRoleGroupMappingServiceImpl")
	public void setUserRoleGroupMappingService(IUserRoleGroupMappingService userRoleGroupMappingService) {
		this.userRoleGroupMappingService = userRoleGroupMappingService;
	}

}
