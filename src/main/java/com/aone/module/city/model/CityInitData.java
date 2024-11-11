package com.aone.module.city.model;

import java.util.List;

import com.aone.module.state.model.State;

public class CityInitData {
	List<State> stateList;
	
	public List<State> getStateList() {
		return stateList;
	}
	
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	@Override
	public String toString() {
		return "CityInitData [stateList=" + stateList + "]";
	}
	
}
