package com.aone.config.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.service.IContactService;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRole.service.IUserRoleService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private static Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);
	
	//private IUserService userService;
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
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Contact contact = contactService.getByUserName(userName);
		if (contact == null) {
			throw new UsernameNotFoundException("Sorry! User not available");
		}
		return new org.springframework.security.core.userdetails.User(contact.getUserName(), contact.getPasswordHash(), true,
				true, true, true, getGrantedAuthorities(contact));
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(Contact contact) {
		try {
			List<UserRole> userRoleList = Collections.emptyList();
			if(contact.getUserName().equals("sa") || contact.getUserName().equals("admin")) {
				SearchData<UserRole> searchData = new SearchData<>();
				userRoleList = userRoleService.getActiveData(searchData);
			} else {
				userRoleList = userRoleService.getByContactId(contact.getId());
			}
			
			LOGGER.info("=====================================================");
			LOGGER.info(userRoleList);
			LOGGER.info("=====================================================");
			List<GrantedAuthority> authorities = new ArrayList<>();
			for(UserRole userRole : userRoleList) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole()));
			}
			return authorities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
