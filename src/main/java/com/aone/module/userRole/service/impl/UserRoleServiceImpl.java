package com.aone.module.userRole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.userRole.dao.IUserRoleDao;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRole.service.IUserRoleService;

@Lazy
@Service("userRoleServiceImpl")
public class UserRoleServiceImpl extends AbstractBaseMasterService<UserRole, Long, IUserRoleDao>
		implements IUserRoleService {

	private IUserRoleDao userRoleDao;
	
	@Override
	public IUserRoleDao getRepository() {
		return getUserRoleDao();
	}

	public IUserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	@Autowired
	@Qualifier(value = "userRoleDaoImpl")
	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkUserRoleName(RequestData<UserRole, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getRole(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(UserRole userRole) {
		if(userRole == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(userRole.getRole() == null || userRole.getRole().isEmpty()) {
			return ResultCodeConstant.USER_ROLE_NAME_NOT_FOUND;
		}
		// check if UserRole name already exist
		if(!getRepository().checkUniqueDataByField("name", userRole.getRole(), "id", userRole.getId()).isEmpty()) {
			return ResultCodeConstant.USER_ROLE_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public List<UserRole> getByContactId(long contactId) {
		return userRoleDao.getByContactId(contactId);
	}

}
