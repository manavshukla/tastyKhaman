package com.aone.module.userRoleGroupDetails.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;

public interface IUserRoleGroupDetailsService  extends IBaseMasterService<UserRoleGroupDetails , Long>{

	public List<UserRoleGroupDetails> getByUserRoleGroupId(long userRoleGroupId);

	public int deleteByUserRoleGroupId(long userRoleGroupId);

}
