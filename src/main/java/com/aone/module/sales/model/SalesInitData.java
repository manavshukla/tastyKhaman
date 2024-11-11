package com.aone.module.sales.model;

import java.util.List;

import com.aone.module.address.model.AddressDataList;
import com.aone.module.contact.model.ContactTypeDataList;
import com.aone.module.item.model.Item;

public class SalesInitData {
	private ContactTypeDataList contacts;
	private List<Item> itemList;
	private AddressDataList addressDataList;

	public AddressDataList getAddressDataList() {
		return addressDataList;
	}

	public void setAddressDataList(AddressDataList addressDataList) {
		this.addressDataList = addressDataList;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public ContactTypeDataList getContacts() {
		return contacts;
	}

	public void setContacts(ContactTypeDataList contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "SalesInitData [contacts=" + contacts + ", itemList=" + itemList + ", addressDataList=" + addressDataList
				+ "]";
	}
	
}
