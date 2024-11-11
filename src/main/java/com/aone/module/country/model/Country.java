package com.aone.module.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.country.constant.CountryDbColPojoConstant;

@Entity
@Table(name = "country_master")
public class Country extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = CountryDbColPojoConstant.SORTNAME)
	private String sortName;
	
	@Column(name = CountryDbColPojoConstant.NAME)
	private String name;
	
	
	@Column(name = CountryDbColPojoConstant.PHONECODE)
	private String phoneCode;

	@Column(name = CountryDbColPojoConstant.SYSTEMINSERTED)
	private String systemInserted;

	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneCode() {
		return phoneCode;
	}


	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}


	public String getSystemInserted() {
		return systemInserted;
	}


	public void setSystemInserted(String systemInserted) {
		this.systemInserted = systemInserted;
	}


	@Override
	public String toString() {
		return "Country [sortName=" + sortName + ", name=" + name + ", phoneCode=" + phoneCode + ", systemInserted="
				+ systemInserted + "]";
	}
}
