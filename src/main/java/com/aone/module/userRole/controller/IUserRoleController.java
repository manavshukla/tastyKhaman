package com.aone.module.userRole.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.userRole.model.UserRole;

public interface IUserRoleController extends IBaseMasterController<UserRole, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkUserRoleName(@RequestBody RequestData<UserRole,Long> requestData);

}
