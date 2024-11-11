package com.aone.module.state.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.state.constant.StateDbColPojoConstant;

@Entity
@Table(name = "state_master")
public class State extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = StateDbColPojoConstant.NAME)
	private String name;

	@Column(name = StateDbColPojoConstant.COUNTRY_ID)
	private long countryId;

	@Column(name = StateDbColPojoConstant.CODE)
	private long code;

	@Column(name = StateDbColPojoConstant.SYSTEMINSERTED)
	private String systemInserted;
	
	@Transient
	private StateInitData stateInitData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getSystemInserted() {
		return systemInserted;
	}

	public void setSystemInserted(String systemInserted) {
		this.systemInserted = systemInserted;
	}
	
	public StateInitData getStateInitData() {
		return stateInitData;
	}

	public void setStateInitData(StateInitData stateInitData) {
		this.stateInitData = stateInitData;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", countryId=" + countryId + ", code=" + code + ", systemInserted="
				+ systemInserted + ", stateInitData=" + stateInitData + "]";
	}

}
