package com.aone.module.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.aone.corelibrary.model.impl.AbstractBaseMasterLongKeyEntity;
import com.aone.module.user.constant.UserDbColPojoConstant;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;

/**
 * 
 * User class is used to represent tbl_users table in database
 * 
 * To assign roles to user we are using profile based role management system for
 * that User class mapping with Profile class with relationship Many To Many.
 * 
 * @author everest
 * @since 1.0
 * 
 */

@Entity
@Table(name = "user")
public class User extends AbstractBaseMasterLongKeyEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1910659616068183431L;

	@Column(name = UserDbColPojoConstant.NAME, length = 255)
	private String name;
	
	@Column(name = UserDbColPojoConstant.USER_NAME, length = 255)
	private String userName;

	@Column(name = UserDbColPojoConstant.PASSWORD_HASH, length = 100)
	@Size(message = "user.validation.password.size")
	private String passwordHash;

	@Column(name = UserDbColPojoConstant.STATUS, columnDefinition = "int default 1")
	private int status;

	@Column(name = UserDbColPojoConstant.SUPER_ADMIN, columnDefinition = "int default 0")
	private int superadmin;

	@Column(name = UserDbColPojoConstant.EMAIL, length = 128)
	private String email;
	
	@Transient
	private List<UserRoleGroupMapping> userRoleGroupMappingList;
	
	@Transient
	private List<UserRole> userRoleList;
	
	@Transient
	private UserInitData userInitData;

	/**
	 * Constructor
	 */
	public User() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(int superadmin) {
		this.superadmin = superadmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public List<UserRoleGroupMapping> getUserRoleGroupMappingList() {
		return userRoleGroupMappingList;
	}

	public void setUserRoleGroupMappingList(List<UserRoleGroupMapping> userRoleGroupMappingList) {
		this.userRoleGroupMappingList = userRoleGroupMappingList;
	}
	
	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public UserInitData getUserInitData() {
		return userInitData;
	}

	public void setUserInitData(UserInitData userInitData) {
		this.userInitData = userInitData;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userName=" + userName + ", passwordHash=" + passwordHash + ", status=" + status + ", superadmin=" + superadmin + ", email=" + email + ", userRoleGroupMappingList=" + userRoleGroupMappingList + ", userRoleList=" + userRoleList + ", userInitData=" + userInitData + "]";
	}

}
