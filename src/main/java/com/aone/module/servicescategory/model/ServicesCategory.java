package com.aone.module.servicescategory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.servicescategory.constant.ServicesCategoryDbColmPojoConstant;

@Entity
@Table(name = "services_category")
public class ServicesCategory extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7038293081954574066L;

	@Column(name=ServicesCategoryDbColmPojoConstant.DESCRIPTION)
	private String description;

	@Column(name=ServicesCategoryDbColmPojoConstant.NAME)
	private String name;
	
	@Column(name=ServicesCategoryDbColmPojoConstant.PARENT_CATEGORY_ID)
	private long parentCategoryId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	@Override
	public String toString() {
		return "ServicesCategory [ description=" + description + ", name=" + name + ", parentCategoryId="
				+ parentCategoryId + "]";
	}
	
}
