package com.aone.module.user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.config.security.annotation.SecurityMethodRole;
import com.aone.config.security.constant.RoleMatcher;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.user.controller.IUserController;
import com.aone.module.user.model.User;
import com.aone.module.user.service.IUserService;

@RestController
@RequestMapping("/rest/user")
@SecurityClassRole(baseRoleName = SecurityRoleModule.USER)
public class UserRestController extends AbstractBaseMasterRestController<User, Long, IUserService>
		implements IUserController {

	private IUserService userService;

	@Override
	public IUserService getService() {
		return getUserService();
	}
	
	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	@Qualifier(value = "userServiceImpl")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	@RequestMapping(value = "/checkUserName", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	@SecurityMethodRole(roleList = { "SAVE", "UPDATE" }, roleMatcher = RoleMatcher.ANY)
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkUserName(@RequestBody RequestData<User, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().checkUserName(requestData);
	}
}
