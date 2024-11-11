package com.aone.module.city.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.city.constant.CityDbColPojoConstant;

@Entity
@Table(name = "city_master")
public class City extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = CityDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = CityDbColPojoConstant.STATE_ID)
	private long stateId;
	
	@Column(name = CityDbColPojoConstant.DESCRIPTION)
	private String description;

	@Column(name = CityDbColPojoConstant.SYSTEMINSERTED)
	private String systemInserted;
	
	@Transient
	private  CityInitData cityInitData;
	
	
	public CityInitData getCityInitData() {
		return cityInitData;
	}

	public void setCityInitData(CityInitData cityInitData) {
		this.cityInitData = cityInitData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSystemInserted() {
		return systemInserted;
	}

	public void setSystemInserted(String systemInserted) {
		this.systemInserted = systemInserted;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", stateId=" + stateId + ", description=" + description + ", systemInserted="
				+ systemInserted + ", cityInitData=" + cityInitData + "]";
	}
}
