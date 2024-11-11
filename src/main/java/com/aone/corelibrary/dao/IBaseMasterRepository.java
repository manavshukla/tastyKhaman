package com.aone.corelibrary.dao;

import java.io.Serializable;

import com.aone.corelibrary.model.IBaseMasterEntity;

public interface IBaseMasterRepository<T extends IBaseMasterEntity<K> , K extends Serializable> extends IBaseRepository<T, K> {
	
}
