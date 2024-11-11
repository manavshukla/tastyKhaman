package com.aone.module.contact.model;

import java.util.List;

import com.aone.module.address.model.AddressDataList;
import com.aone.module.contactCategory.model.ContactCategory;
import com.aone.module.userRoleGroup.model.UserRoleGroup;

public class ContactInitData {

	private AddressDataList addressDataList;
	private List<ContactCategory> contactCategoryList;
	private List<UserRoleGroup> userRoleGroupList;
	public AddressDataList getAddressDataList() {
		return addressDataList;
	}

	public void setAddressDataList(AddressDataList addressDataList) {
		this.addressDataList = addressDataList;
	}
	
	public List<ContactCategory> getContactCategoryList() {
		return contactCategoryList;
	}

	public void setContactCategoryList(List<ContactCategory> contactCategoryList) {
		this.contactCategoryList = contactCategoryList;
	}

	public List<UserRoleGroup> getUserRoleGroupList() {
		return userRoleGroupList;
	}

	public void setUserRoleGroupList(List<UserRoleGroup> userRoleGroupList) {
		this.userRoleGroupList = userRoleGroupList;
	}

	@Override
	public String toString() {
		return "ContactInitData [addressDataList=" + addressDataList + ", contactCategoryList=" + contactCategoryList
				+ ", userRoleGroupList=" + userRoleGroupList + "]";
	}
}
