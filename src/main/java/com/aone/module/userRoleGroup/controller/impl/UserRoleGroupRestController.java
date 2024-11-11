package com.aone.module.userRoleGroup.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.config.security.annotation.SecurityMethodRole;
import com.aone.config.security.constant.RoleMatcher;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.userRoleGroup.controller.IUserRoleGroupController;
import com.aone.module.userRoleGroup.model.UserRoleGroup;
import com.aone.module.userRoleGroup.service.IUserRoleGroupService;

@RestController
@RequestMapping("/rest/userRoleGroup")
@SecurityClassRole(baseRoleName = SecurityRoleModule.USER_ROLE_GROUP)
public class UserRoleGroupRestController extends AbstractBaseMasterRestController<UserRoleGroup, Long, IUserRoleGroupService> implements IUserRoleGroupController {

	private IUserRoleGroupService userRoleGroupService;
	
	@Override
	public IUserRoleGroupService getService() {
		return getUserRoleGroupService();
	}

	public IUserRoleGroupService getUserRoleGroupService() {
		return userRoleGroupService;
	}

	@Autowired
	@Qualifier(value="userRoleGroupServiceImpl")
	public void setUserRoleGroupService(IUserRoleGroupService userRoleGroupService) {
		this.userRoleGroupService = userRoleGroupService;
	}
	
	@Override
	@RequestMapping(value="/checkUserRoleGroupName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "SAVE", "UPDATE" }, roleMatcher = RoleMatcher.ANY)
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkUserRoleGroupName(@RequestBody RequestData<UserRoleGroup,Long> requestData) {
		return getService().checkUserRoleGroupName(requestData);
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<UserRoleGroup>> getActiveData(@RequestBody RequestData<SearchData<UserRoleGroup>, Long> requestData) {
		return super.getActiveData(requestData);
	}
	
}
