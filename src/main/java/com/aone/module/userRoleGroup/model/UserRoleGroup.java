package com.aone.module.userRoleGroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.userRoleGroup.constant.UserRoleGroupDbColmPojoConstant;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;

@Entity
@Table(name = "user_role_group")
public class UserRoleGroup extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -7267481802573882486L;

	@Column(name=UserRoleGroupDbColmPojoConstant.NAME)
	private String name;
	
	@Column(name=UserRoleGroupDbColmPojoConstant.DESCRIPTION)
	private String description;
	
	@Transient
	private List<UserRoleGroupDetails> userRoleGroupDetails;

	@Transient
	private UserRoleGroupInit userRoleGroupInit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserRoleGroupDetails> getUserRoleGroupDetails() {
		return userRoleGroupDetails;
	}

	public void setUserRoleGroupDetails(List<UserRoleGroupDetails> userRoleGroupDetails) {
		this.userRoleGroupDetails = userRoleGroupDetails;
	}

	
	public UserRoleGroupInit getUserRoleGroupInit() {
		return userRoleGroupInit;
	}

	public void setUserRoleGroupInit(UserRoleGroupInit userRoleGroupInit) {
		this.userRoleGroupInit = userRoleGroupInit;
	}

	@Override
	public String toString() {
		return "UserRoleGroup [name=" + name + ", description=" + description + ", userRoleGroupDetails=" + userRoleGroupDetails +
				", userRoleGroupInit=" + userRoleGroupInit +"]";
	}

}
