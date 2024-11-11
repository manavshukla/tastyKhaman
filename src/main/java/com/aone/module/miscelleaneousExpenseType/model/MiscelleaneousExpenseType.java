package com.aone.module.miscelleaneousExpenseType.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.city.constant.CityDbColPojoConstant;

@Entity
@Table(name = "miscelleaneous_expense_type")
public class MiscelleaneousExpenseType extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = CityDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = CityDbColPojoConstant.DESCRIPTION)
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
		return "MiscelleaneousExpenseType [name=" + name + ", description="
				+ description + "]";
	}
}
