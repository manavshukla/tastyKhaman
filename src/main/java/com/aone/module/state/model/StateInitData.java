package com.aone.module.state.model;

import java.util.List;

import com.aone.module.country.model.Country;

public class StateInitData {

	private List<Country> countryList;

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	@Override
	public String toString() {
		return "StateInitData [countryList=" + countryList + "]";
	}
	
}
