package com.aone.module.contactCategory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactCategory.constant.ContactCategoryDbColPojoConstant;

@Entity
@Table(name = "contact_category")
public class ContactCategory extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ContactCategoryDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = ContactCategoryDbColPojoConstant.DESCRIPTION)
	private String description;

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

	@Override
	public String toString() {
		return "ContactCategory [name=" + name + ", description=" + description + "]";
	}

}
