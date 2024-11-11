package com.aone.module.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.address.constant.AddressDbColPojoConstant;

@Entity
@Table(name = "address")
public class Address extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = AddressDbColPojoConstant.STREET)
	private String street;

	@Column(name = AddressDbColPojoConstant.CITY_ID)
	private long cityId;

	@Column(name = AddressDbColPojoConstant.STATE_ID)
	private long stateId;

	@Column(name = AddressDbColPojoConstant.COUNTRY_ID)
	private long countryId;

	@Column(name = AddressDbColPojoConstant.ZIPCODE)
	private long zipCode;



	@Column(name = AddressDbColPojoConstant.FOREIGN_KEY)
	private long foreinKey;

	@Column(name = AddressDbColPojoConstant.MODULE_NAME)
	private String moduleName;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public long getForeinKey() {
		return foreinKey;
	}

	public void setForeinKey(long foreinKey) {
		this.foreinKey = foreinKey;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId=" + countryId
				+ ", zipCode=" + zipCode + ", foreinKey=" + foreinKey + ", moduleName=" + moduleName + "]";
	}

}
