package com.aone.module.userRoleGroup.model;

import java.util.List;

import com.aone.module.userRole.model.UserRole;

public class UserRoleGroupInit {
	private List<UserRole> userRoleList;

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	@Override
	public String toString() {
		return "UserRoleGroupInit [userRoleList=" + userRoleList + "]";
	}
	
}
