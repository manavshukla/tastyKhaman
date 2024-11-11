package com.aone.module.userRoleGroup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.userRoleGroup.model.UserRoleGroup;

public interface IUserRoleGroupController extends IBaseMasterController<UserRoleGroup, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkUserRoleGroupName(@RequestBody RequestData<UserRoleGroup,Long> requestData);

}
