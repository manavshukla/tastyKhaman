package com.aone.corelibrary.service;

import java.io.Serializable;

import com.aone.corelibrary.model.IBaseMasterEntity;

public interface IBaseMasterService<T extends IBaseMasterEntity<K>, K extends Serializable> extends IBaseService<T, K> {

}
