package com.aone.corelibrary.model;

import java.io.Serializable;

public interface IBaseEntity<K extends Serializable> {

	K getId();

	void setDeleted(boolean deleted);
	
	public boolean setDefaultValueForObject();
	
}
