package com.aone.module.userRoleGroupDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.userRoleGroupDetails.controller.IUserRoleGroupDetailsController;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;
import com.aone.module.userRoleGroupDetails.service.IUserRoleGroupDetailsService;

@RestController
@RequestMapping("/rest/userRoleGroupDetails")
public class UserRoleGroupDetailsRestController extends AbstractBaseMasterRestController<UserRoleGroupDetails , Long, IUserRoleGroupDetailsService> implements IUserRoleGroupDetailsController {
	
	private IUserRoleGroupDetailsService userRoleGroupDetailsService;
	
	@Override
	public IUserRoleGroupDetailsService getService() {
		return getUserRoleGroupDetailsService();
	}

	public IUserRoleGroupDetailsService getUserRoleGroupDetailsService() {
		return userRoleGroupDetailsService;
	}

	@Autowired        
	@Qualifier(value="userRoleGroupDetailsServiceImpl")
	public void setUserRoleGroupDetailsService(IUserRoleGroupDetailsService userRoleGroupDetailsService) {
		this.userRoleGroupDetailsService = userRoleGroupDetailsService;
	}

}
