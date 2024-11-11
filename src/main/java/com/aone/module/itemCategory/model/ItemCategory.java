package com.aone.module.itemCategory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.itemCategory.constant.ItemCategoryDbColPojoConstant;

@Entity
@Table(name = "item_category_master")
public class ItemCategory extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ItemCategoryDbColPojoConstant.NAME)
	private String name;

	@Column(name = ItemCategoryDbColPojoConstant.DESCRIPTION)
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
		return "ItemCategory [name=" + name + ", description=" + description
				+ "]";
	}

}
