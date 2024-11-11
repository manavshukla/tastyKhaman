package com.aone.module.category.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.category.constant.CategoryDbColmPojoConstant;

@Entity
@Table(name = "BASE_Category")
public class Category extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081954574066L;

	@Column(name=CategoryDbColmPojoConstant.PARENT_CATEGORY_ID)
	private long parentCategoryId;

	@Column(name=CategoryDbColmPojoConstant.NAME)
	private String name;
	
	@Column(name=CategoryDbColmPojoConstant.DESCRIPTION)
	private String description;

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

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
		return "Category [parentCategoryId=" + parentCategoryId + ", name="
				+ name + ", description=" + description + "]";
	}

}
