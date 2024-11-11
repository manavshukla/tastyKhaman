package com.aone.module.userRole.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.userRole.model.UserRole;

public interface IUserRoleService extends IBaseMasterService<UserRole, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkUserRoleName(RequestData<UserRole, Long> requestData);
	
	public List<UserRole> getByContactId(long userId);
}
