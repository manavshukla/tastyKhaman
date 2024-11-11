package com.aone.module.user.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.user.dao.IUserDao;
import com.aone.module.user.model.User;
import com.aone.module.user.model.UserInitData;
import com.aone.module.user.service.IUserService;
import com.aone.module.userRoleGroup.model.UserRoleGroup;
import com.aone.module.userRoleGroup.service.IUserRoleGroupService;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;
import com.aone.module.userRoleGroupMapping.service.IUserRoleGroupMappingService;

@Lazy
@Service("userServiceImpl")
public class UserServiceImpl extends AbstractBaseMasterService<User, Long, IUserDao> implements
		IUserService {
	
	private IUserDao userDao;
	private IUserRoleGroupMappingService userRoleGroupMappingService;
	private IUserRoleGroupService userRoleGroupService;
	
	public IUserRoleGroupService getUserRoleGroupService() {
		return userRoleGroupService;
	}

	@Autowired
	@Qualifier(value="userRoleGroupServiceImpl")
	public void setUserRoleGroupService(IUserRoleGroupService userRoleGroupService) {
		this.userRoleGroupService = userRoleGroupService;
	}
	
	public IUserRoleGroupMappingService getUserRoleGroupMappingService() {
		return userRoleGroupMappingService;
	}

	@Autowired        
	@Qualifier(value="userRoleGroupMappingServiceImpl")
	public void setUserRoleGroupMappingService(IUserRoleGroupMappingService userRoleGroupMappingService) {
		this.userRoleGroupMappingService = userRoleGroupMappingService;
	}
	
	@Override
	public IUserDao getRepository() {
		return getUserDao();
	}

	public IUserDao getUserDao() {
		return userDao;
	}


	@Autowired
	@Qualifier(value = "userDaoImpl")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public ResponseEntity<IResponseData<Boolean>> checkUserName(RequestData<User, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(User user) {
		if(user == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(user.getName() == null || user.getName().isEmpty()) {
			return ResultCodeConstant.UOM_NAME_NOT_FOUND;
		}
		// check if uom name already exist
		if(!getRepository().checkUniqueDataByField("name", user.getName(), "id", user.getId()).isEmpty()) {
			return ResultCodeConstant.UOM_NAME_ALREADY_EXIST;
		}
		
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<User>> save(RequestData<User, Long> requestData) {
		User user = requestData.getData(); 
		
		ResultCodeConstant resultCodeConstant = this.save(user);

		// return the response object to client
		IResponseData<User> responseData = new ResponseData<>(user, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant save(User user) {
		ResultCodeConstant resultCodeConstant = validateData(user);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		
		// save user data
		user =  getRepository().save(user);
		
		//save user role group mapping
		List<UserRoleGroupMapping> userRoleGroupMappingList = user.getUserRoleGroupMappingList();
		if (userRoleGroupMappingList != null) {
			for(UserRoleGroupMapping userRoleGroupMapping : userRoleGroupMappingList) {
				//userRoleGroupMapping.setUserId(user.getId());
				userRoleGroupMappingService.save(userRoleGroupMapping);
			}
		}
		
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<User>> update(RequestData<User, Long> requestData) {
		User user = requestData.getData();

		ResultCodeConstant resultCodeConstant = this.update(user);

		// return the response object to client
		IResponseData<User> responseData = new ResponseData<>(user, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant update(User user) {
		// validate contact data
		ResultCodeConstant resultCodeConstant = validateData(user);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}

		// save contact detail first
		user = getRepository().update(user);

		userRoleGroupMappingService.deleteByUserId(user.getId());
		//save user role group mapping
		List<UserRoleGroupMapping> userRoleGroupMappingList = user.getUserRoleGroupMappingList();
		if (userRoleGroupMappingList != null) {
			for(UserRoleGroupMapping userRoleGroupMapping : userRoleGroupMappingList) {
				//userRoleGroupMapping.setUserId(user.getId());
				userRoleGroupMappingService.save(userRoleGroupMapping);
			}
		}
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<User>> delete(RequestData<User, Long> requestData) {
		ResponseEntity<IResponseData<User>> responseEntity = super.delete(requestData);
		
		User user = requestData.getData();
		
		// delete user role group mapping
		userRoleGroupMappingService.deleteByUserId(user.getId());
		
		return responseEntity;
	}
		
	@Override
	public ResponseEntity<IResponseData<User>> getById(RequestData<User, Long> requestData) {
		
		ResponseEntity<IResponseData<User>> responseEntity = super.getById(requestData);
		
		IResponseData<User> responseData = responseEntity.getBody();
		
		User user = responseData.getData();
		
		// set init data
		UserInitData userInitData = new UserInitData();
		user.setUserInitData(userInitData);
		
		SearchData<UserRoleGroup> userRoleSearchData  = new SearchData<UserRoleGroup>();
		userInitData.setUserRoleGroupList(userRoleGroupService.getActiveData(userRoleSearchData));
		
		user.setUserRoleGroupMappingList(userRoleGroupMappingService.getByUserId(user.getId()));
				
		return responseEntity;
	}
	
	@Override
	public User getByUserName(String userName){
		Map<String, Object> params = new HashMap<>();
		params.put("userName", userName);
		params.put("deleted", false);
		List<User> userList = getRepository().getByQueryData(params, Collections.emptyMap());
		if(userList == null || userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	
}
