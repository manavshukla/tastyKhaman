package com.aone.corelibrary.controller;

import java.io.Serializable;

import com.aone.corelibrary.model.IBaseMasterEntity;

public interface IBaseMasterController<T extends IBaseMasterEntity<K>, K extends Serializable> extends IBaseController<T, K> {

}
