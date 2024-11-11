package com.aone.module.ledgersData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.ledgersData.constant.LedgersDataDbColPojoConstant;

@Entity
@Table(name = "ledgers_data")
public class LedgersData extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -556739734678184202L;

	@Column(name = LedgersDataDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = LedgersDataDbColPojoConstant.CR_DR_FLAG)
	private boolean crDrFlag;
	
	@Column(name = LedgersDataDbColPojoConstant.DISPLAY_NAME)
	private String displayName;
	
	@Column(name = LedgersDataDbColPojoConstant.DESCRIPTION)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCrDrFlag() {
		return crDrFlag;
	}

	public void setCrDrFlag(boolean crDrFlag) {
		this.crDrFlag = crDrFlag;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LedgersData [name=" + name + ", crDrFlag=" + crDrFlag + ", displayName=" + displayName + ", description=" + description + "]";
	}
	
}
