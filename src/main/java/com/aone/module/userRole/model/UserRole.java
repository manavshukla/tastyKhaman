package com.aone.module.userRole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.userRole.constant.UserRoleDbColmPojoConstant;

@Entity
@Table(name = "user_role")
public class UserRole extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -7267481802573882486L;

	@Column(name=UserRoleDbColmPojoConstant.ROLE)
	private String role;
	
	@Column(name=UserRoleDbColmPojoConstant.MODULE_NAME)
	private String moduleName;
	
	@Column(name=UserRoleDbColmPojoConstant.DISPLAY_NAME)
	private String displayName;
	
	@Column(name=UserRoleDbColmPojoConstant.DESCRIPTION)
	private String description;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + ", moduleName=" + moduleName
				+ ", displayName=" + displayName + ", description="
				+ description + "]";
	}

}
