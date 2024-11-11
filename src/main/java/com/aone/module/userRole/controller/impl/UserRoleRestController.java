package com.aone.module.userRole.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.userRole.controller.IUserRoleController;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRole.service.IUserRoleService;

@RestController
@RequestMapping("/rest/userRole")
public class UserRoleRestController extends AbstractBaseMasterRestController<UserRole, Long, IUserRoleService> implements IUserRoleController {

	private IUserRoleService userRoleService;
	
	@Override
	public IUserRoleService getService() {
		return getUserRoleService();
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	@Autowired
	@Qualifier(value="userRoleServiceImpl")
	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	@Override
	@RequestMapping(value="/checkUserRoleName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkUserRoleName(@RequestBody RequestData<UserRole,Long> requestData) {
		return getService().checkUserRoleName(requestData);
	}
	
	
	
}
