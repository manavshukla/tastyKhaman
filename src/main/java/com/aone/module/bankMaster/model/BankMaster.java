package com.aone.module.bankMaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.bankMaster.constant.BankMasterDbColPojoConstant;

@Entity
@Table(name = "bank_master")
public class BankMaster extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = BankMasterDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = BankMasterDbColPojoConstant.DESCRIPTION)
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
		return "BankMaster [name=" + name + ", description=" + description + "]";
	}

}
