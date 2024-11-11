package com.aone.corelibrary.controller.impl;

import java.io.Serializable;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IBaseMasterEntity;
import com.aone.corelibrary.service.IBaseMasterService;


public abstract class AbstractBaseMasterRestController<T extends IBaseMasterEntity<K>, K extends Serializable, E extends IBaseMasterService<T, K>>
		extends AbstractBaseRestController<T, K, E> implements IBaseMasterController<T, K> {

}
