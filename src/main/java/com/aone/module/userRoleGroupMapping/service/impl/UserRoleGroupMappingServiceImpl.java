package com.aone.module.userRoleGroupMapping.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.userRoleGroupMapping.dao.IUserRoleGroupMappingDao;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;
import com.aone.module.userRoleGroupMapping.service.IUserRoleGroupMappingService;

@Lazy
@Service("userRoleGroupMappingServiceImpl")
public class UserRoleGroupMappingServiceImpl extends AbstractBaseMasterService<UserRoleGroupMapping , Long, IUserRoleGroupMappingDao> implements
		IUserRoleGroupMappingService {
	
	private IUserRoleGroupMappingDao userRoleGroupMappingDao;

	@Override
	public IUserRoleGroupMappingDao getRepository() {
		return getUserRoleGroupMappingDao();
	}

	public IUserRoleGroupMappingDao getUserRoleGroupMappingDao() {
		return userRoleGroupMappingDao;
	}

	@Autowired
	@Qualifier(value = "userRoleGroupMappingDaoImpl")
	public void setUserRoleGroupMappingDao(IUserRoleGroupMappingDao userRoleGroupMappingDao) {
		this.userRoleGroupMappingDao = userRoleGroupMappingDao;
	}
	
	@Override
	public List<UserRoleGroupMapping> getByContactId(long contactId){
		Map<String, Object> params = new HashMap<>();
		params.put("contactId", contactId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
	
	@Override
	public List<UserRoleGroupMapping> getByUserId(long userId){
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
	
	@Override
	public int deleteByUserId(long userId){
		return getRepository().deleteByUserId(userId);
	}

	@Override
	public int deleteByContactId(long contactId) {
		return getRepository().deleteByContactId(contactId);
	}
	
}