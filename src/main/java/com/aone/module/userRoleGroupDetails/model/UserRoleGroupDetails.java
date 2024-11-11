package com.aone.module.userRoleGroupDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.userRoleGroupDetails.constant.UserRoleGroupDetailsDbColPojoConstant;

@Entity
@Table(name = "user_role_group_details")
public class UserRoleGroupDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = UserRoleGroupDetailsDbColPojoConstant.USER_ROLE_GROUP_ID)
	private long userRoleGroupId;
	
	@Column(name = UserRoleGroupDetailsDbColPojoConstant.USER_ROLE_ID)
	private long userRoleId;
	
	@Column(name = UserRoleGroupDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getUserRoleGroupId() {
		return userRoleGroupId;
	}

	public void setUserRoleGroupId(long userRoleGroupId) {
		this.userRoleGroupId = userRoleGroupId;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserRoleGroupDetails [userRoleGroupId=" + userRoleGroupId + ", userRoleId=" + userRoleId + ", description=" + description + "]";
	}

}
