package com.aone.module.userRoleGroupDetails.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.userRoleGroupDetails.dao.IUserRoleGroupDetailsDao;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;
import com.aone.module.userRoleGroupDetails.service.IUserRoleGroupDetailsService;

@Lazy
@Service("userRoleGroupDetailsServiceImpl")
public class UserRoleGroupDetailsServiceImpl extends AbstractBaseMasterService<UserRoleGroupDetails , Long, IUserRoleGroupDetailsDao> implements
		IUserRoleGroupDetailsService {
	
	private IUserRoleGroupDetailsDao userRoleGroupDetailsDao;

	@Override
	public IUserRoleGroupDetailsDao getRepository() {
		return getUserRoleGroupDetailsDao();
	}

	public IUserRoleGroupDetailsDao getUserRoleGroupDetailsDao() {
		return userRoleGroupDetailsDao;
	}

	@Autowired
	@Qualifier(value = "userRoleGroupDetailsDaoImpl")
	public void setUserRoleGroupDetailsDao(IUserRoleGroupDetailsDao userRoleGroupDetailsDao) {
		this.userRoleGroupDetailsDao = userRoleGroupDetailsDao;
	}
	
	@Override
	public List<UserRoleGroupDetails> getByUserRoleGroupId(long userRoleGroupId){
		Map<String, Object> params = new HashMap<>();
		params.put("userRoleGroupId", userRoleGroupId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
	
	@Override
	public int deleteByUserRoleGroupId(long userRoleGroupId){
		return getRepository().deleteByUserRoleGroupId(userRoleGroupId);
	}
	
}