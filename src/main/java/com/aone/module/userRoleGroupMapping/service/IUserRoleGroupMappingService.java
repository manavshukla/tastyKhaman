package com.aone.module.userRoleGroupMapping.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;

public interface IUserRoleGroupMappingService  extends IBaseMasterService<UserRoleGroupMapping , Long>{

	public List<UserRoleGroupMapping> getByContactId(long contactId);
	
	public List<UserRoleGroupMapping> getByUserId(long userId);

	public int deleteByUserId(long userId);

	public int deleteByContactId(long contactId);

}
