package com.aone.module.contactWiseItemRate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactWiseItemRate.constant.ContactWiseItemRateDbColPojoConstant;

@Entity
@Table(name = "contact_wise_item_rate")
public class ContactWiseItemRate extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ContactWiseItemRateDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = ContactWiseItemRateDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = ContactWiseItemRateDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = ContactWiseItemRateDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ContactWiseItemRate [contactId=" + contactId + ", itemId=" + itemId + ", price=" + price
				+ ", description=" + description + "]";
	}

}
