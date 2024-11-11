package com.aone.module.contact.model;

import java.util.List;

public class ContactListData {

	private List<Contact> contactList;

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	@Override
	public String toString() {
		return "ContactListData [contactList=" + contactList + "]";
	}

}
