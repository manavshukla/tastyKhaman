package com.aone.module.userRoleGroupMapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.userRoleGroupMapping.constant.UserRoleGroupMappingDbColPojoConstant;

@Entity
@Table(name = "user_role_group_mapping")
public class UserRoleGroupMapping extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 2663940066178421343L;

	@Column(name = UserRoleGroupMappingDbColPojoConstant.USER_ROLE_GROUP_ID)
	private long userRoleGroupId;
	
	@Column(name = UserRoleGroupMappingDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = UserRoleGroupMappingDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getUserRoleGroupId() {
		return userRoleGroupId;
	}

	public void setUserRoleGroupId(long userRoleGroupId) {
		this.userRoleGroupId = userRoleGroupId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserRoleGroupMapping [userRoleGroupId=" + userRoleGroupId + ", contactId=" + contactId + ", description=" + description + "]";
	}

}
