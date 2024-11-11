package com.aone.module.userRoleGroup.service.impl;

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
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRole.service.IUserRoleService;
import com.aone.module.userRoleGroup.dao.IUserRoleGroupDao;
import com.aone.module.userRoleGroup.model.UserRoleGroup;
import com.aone.module.userRoleGroup.model.UserRoleGroupInit;
import com.aone.module.userRoleGroup.service.IUserRoleGroupService;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;
import com.aone.module.userRoleGroupDetails.service.IUserRoleGroupDetailsService;

@Lazy
@Service("userRoleGroupServiceImpl")
public class UserRoleGroupServiceImpl extends AbstractBaseMasterService<UserRoleGroup, Long, IUserRoleGroupDao>
		implements IUserRoleGroupService {

	private IUserRoleGroupDao userRoleGroupDao;
	private IUserRoleGroupDetailsService userRoleGroupDetailsService;
	private IUserRoleService userRoleService;

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	@Autowired
	@Qualifier(value="userRoleServiceImpl")
	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	public IUserRoleGroupDetailsService getUserRoleGroupDetailsService() {
		return userRoleGroupDetailsService;
	}

	@Autowired        
	@Qualifier(value="userRoleGroupDetailsServiceImpl")
	public void setUserRoleGroupDetailsService(IUserRoleGroupDetailsService userRoleGroupDetailsService) {
		this.userRoleGroupDetailsService = userRoleGroupDetailsService;
	}

	@Override
	public IUserRoleGroupDao getRepository() {
		return getUserRoleGroupDao();
	}

	public IUserRoleGroupDao getUserRoleGroupDao() {
		return userRoleGroupDao;
	}

	@Autowired
	@Qualifier(value = "userRoleGroupDaoImpl")
	public void setUserRoleGroupDao(IUserRoleGroupDao userRoleGroupDao) {
		this.userRoleGroupDao = userRoleGroupDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkUserRoleGroupName(RequestData<UserRoleGroup, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(UserRoleGroup userRoleGroup) {
		if(userRoleGroup == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(userRoleGroup.getName() == null || userRoleGroup.getName().isEmpty()) {
			return ResultCodeConstant.USER_ROLE_NAME_NOT_FOUND;
		}
		// check if UserRoleGroup name already exist
		if(!getRepository().checkUniqueDataByField("name", userRoleGroup.getName(), "id", userRoleGroup.getId()).isEmpty()) {
			return ResultCodeConstant.USER_ROLE_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<UserRoleGroup>> save(RequestData<UserRoleGroup, Long> requestData) {
		UserRoleGroup userRoleGroup = requestData.getData(); 
		
		ResultCodeConstant resultCodeConstant = this.save(userRoleGroup);

		// return the response object to client
		IResponseData<UserRoleGroup> responseData = new ResponseData<>(userRoleGroup, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant save(UserRoleGroup userRoleGroup) {
		ResultCodeConstant resultCodeConstant = validateData(userRoleGroup);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		
		// save user data
		userRoleGroup =  getRepository().save(userRoleGroup);
		
		//save user role group details
		List<UserRoleGroupDetails> userRoleGroupDetailsList = userRoleGroup.getUserRoleGroupDetails();
		if (userRoleGroupDetailsList != null) {
			for(UserRoleGroupDetails userRoleGroupDetails : userRoleGroupDetailsList) {
				userRoleGroupDetails.setUserRoleGroupId(userRoleGroup.getId());
				userRoleGroupDetailsService.save(userRoleGroupDetails);
			}
		}
		
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<UserRoleGroup>> update(RequestData<UserRoleGroup, Long> requestData) {
		UserRoleGroup userRoleGroup = requestData.getData();

		ResultCodeConstant resultCodeConstant = this.update(userRoleGroup);

		// return the response object to client
		IResponseData<UserRoleGroup> responseData = new ResponseData<>(userRoleGroup, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant update(UserRoleGroup userRoleGroup) {
		// validate contact data
		ResultCodeConstant resultCodeConstant = validateData(userRoleGroup);
		if (ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}

		// save contact detail first
		userRoleGroup = getRepository().update(userRoleGroup);

		userRoleGroupDetailsService.deleteByUserRoleGroupId(userRoleGroup.getId());
		//update user role group details
		List<UserRoleGroupDetails> userRoleGroupDetailsList = userRoleGroup.getUserRoleGroupDetails();
		if (userRoleGroupDetailsList != null) {
			for(UserRoleGroupDetails userRoleGroupDetails : userRoleGroupDetailsList) {
				userRoleGroupDetails.setUserRoleGroupId(userRoleGroup.getId());
				userRoleGroupDetailsService.save(userRoleGroupDetails);
			}
		}
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<UserRoleGroup>> delete(RequestData<UserRoleGroup, Long> requestData) {
		ResponseEntity<IResponseData<UserRoleGroup>> responseEntity = super.delete(requestData);
		
		UserRoleGroup userRoleGroup = requestData.getData();
		
		// delete user role group details
		userRoleGroupDetailsService.deleteByUserRoleGroupId(userRoleGroup.getId());
		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<IResponseData<UserRoleGroup>> getById(RequestData<UserRoleGroup, Long> requestData) {
		ResponseEntity<IResponseData<UserRoleGroup>> responseEntity = super.getById(requestData); 
		
		IResponseData<UserRoleGroup> responseData = responseEntity.getBody();
		
		UserRoleGroup userRoleGroup = responseData.getData();
		
		// set init data
		UserRoleGroupInit userRoleGroupInit = new UserRoleGroupInit();
		userRoleGroup.setUserRoleGroupInit(userRoleGroupInit);
		
		SearchData<UserRole> userRoleSearchData = new SearchData<UserRole>();
		userRoleGroupInit.setUserRoleList(userRoleService.getActiveData(userRoleSearchData));
		
		userRoleGroup.setUserRoleGroupDetails(userRoleGroupDetailsService.getByUserRoleGroupId(requestData.getId()));
		
		return responseEntity;
	}

}
