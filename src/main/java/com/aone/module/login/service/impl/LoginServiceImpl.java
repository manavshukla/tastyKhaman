package com.aone.module.login.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.aone.commons.utils.PropertyUtil;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.service.IContactService;
import com.aone.module.login.service.ILoginService;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRole.service.IUserRoleService;

@Lazy
@Service("loginServiceImpl")
public class LoginServiceImpl implements ILoginService {
	
//	private IUserService userService;
	private IUserRoleService userRoleService;
	private IContactService contactService;

	/**
	 * @return the contactService
	 */
	public IContactService getContactService() {
		return contactService;
	}

	/**
	 * @param contactService the contactService to set
	 */
	@Autowired        
	@Qualifier(value="contactServiceImpl")
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	@Autowired
	@Qualifier(value="userRoleServiceImpl")
	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	/*public IUserService getUserService() {
		return userService;
	}

	@Autowired
	@Qualifier(value = "userServiceImpl")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}*/
	
	@Override
	public Contact getCurrentLoginUserDetails() {
		
		String userName = getCurrentLoginUserName();
		
		Contact contact = contactService.getByUserName(userName);

		//fetch and set user Role
		List<UserRole> userRoleList = null;
		if(PropertyUtil.checkProdEnv()) {
			//PROD-- start
			if(userName.equals("sa") || userName.equals("admin")) {
				SearchData<UserRole> searchData = new SearchData<>();
				userRoleList = userRoleService.getActiveData(searchData);
			} else {
				userRoleList = userRoleService.getByContactId(contact.getId());
			}
			//PROD-- end
		} else {
			//DEV-- start
			userRoleList = userRoleService.getByContactId(contact.getId());
			//DEV-- end
		}
		
		contact.setUserRoleList(userRoleList);
		return contact;
	}
	
	@Override
	public ResponseEntity<IResponseData<Contact>> getCurrentLoginUserDetails(RequestData<Contact, Long> requestData) {
		Contact contact = getCurrentLoginUserDetails();
		contact.setPasswordHash(StringUtils.EMPTY);
		IResponseData<Contact> responseData = new ResponseData<>(contact, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public boolean checkIfHasPermission(String moduleName, String permisson) {
		Contact contact = getCurrentLoginUserDetails();
		String modulePermission = moduleName + permisson;
		for (UserRole userRole : contact.getUserRoleList()) {
			if (userRole.getModuleName().equals(modulePermission)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getCurrentLoginUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = null;
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		
		//DEV-- start
		if(!PropertyUtil.checkProdEnv() && (userName == null || userName.isEmpty() || userName.equals("anonymousUser"))) {
			userName = "admin";
		}
		//DEV-- end
		
		return userName;
	}
	
}
