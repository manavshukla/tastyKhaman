package com.aone.module.address.model;

import java.util.List;

import com.aone.module.city.model.City;
import com.aone.module.country.model.Country;
import com.aone.module.state.model.State;

public class AddressDataList {
	private List<Country> countryList;
	private List<State> stateList;
	private List<City> cityList;
	public List<Country> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	public List<State> getStateList() {
		return stateList;
	}
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	@Override
	public String toString() {
		return "AddressDataList [countryList=" + countryList + ", stateList=" + stateList + ", cityList=" + cityList
				+ "]";
	}
	
}
