package com.aone.module.userRoleGroup.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.userRoleGroup.model.UserRoleGroup;

public interface IUserRoleGroupService extends IBaseMasterService<UserRoleGroup, Long> {

	ResponseEntity<IResponseData<Boolean>> checkUserRoleGroupName(RequestData<UserRoleGroup, Long> requestData);
}
