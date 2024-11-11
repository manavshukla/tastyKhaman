package com.aone.module.itemSize.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.company.constant.CompanyDbColmPojoConstant;

@Entity
@Table(name = "itemSize")
public class ItemSize extends AbstractBaseMasterEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3496248133350566329L;

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
		return "Item Size [name=" + name + ", description=" + description + "]";
	}

}
