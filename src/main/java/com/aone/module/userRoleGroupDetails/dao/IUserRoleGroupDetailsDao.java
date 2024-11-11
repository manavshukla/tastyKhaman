package com.aone.module.userRoleGroupDetails.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;

public interface IUserRoleGroupDetailsDao extends IBaseMasterRepository<UserRoleGroupDetails , Long>{

	public int deleteByUserRoleGroupId(long userRoleGroupId);

}
