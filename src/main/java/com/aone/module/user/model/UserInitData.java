package com.aone.module.user.model;

import java.util.List;

import com.aone.module.userRoleGroup.model.UserRoleGroup;

public class UserInitData {

	private List<UserRoleGroup> userRoleGroupList;

	public List<UserRoleGroup> getUserRoleGroupList() {
		return userRoleGroupList;
	}

	public void setUserRoleGroupList(List<UserRoleGroup> userRoleGroupList) {
		this.userRoleGroupList = userRoleGroupList;
	}

	@Override
	public String toString() {
		return "UserInitData [userRoleGroupList=" + userRoleGroupList + "]";
	}
	
}
