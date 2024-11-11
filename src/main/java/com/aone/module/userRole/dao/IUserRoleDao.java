package com.aone.module.userRole.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.userRole.model.UserRole;

public interface IUserRoleDao extends IBaseMasterRepository<UserRole, Long> {

	public List<UserRole> getByContactId(long userId);

}
