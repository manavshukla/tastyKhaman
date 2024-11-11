package com.aone.module.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.company.constant.CompanyDbColmPojoConstant;

@Entity
@Table(name = "company")
public class Company extends AbstractBaseMasterEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -665910601845947257L;

	@Column(name=CompanyDbColmPojoConstant.NAME)
	private String name;
	
	@Column(name=CompanyDbColmPojoConstant.DESCRIPTION)
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
		return "Company [name=" + name + ", description=" + description + "]";
	}

}
