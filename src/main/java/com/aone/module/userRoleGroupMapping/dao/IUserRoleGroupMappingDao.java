package com.aone.module.userRoleGroupMapping.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;

public interface IUserRoleGroupMappingDao extends IBaseMasterRepository<UserRoleGroupMapping , Long>{

	public int deleteByUserId(long userId);

	public int deleteByContactId(long contactId);

}
