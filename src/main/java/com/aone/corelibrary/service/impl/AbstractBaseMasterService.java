package com.aone.corelibrary.service.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.corelibrary.model.IBaseMasterEntity;
import com.aone.corelibrary.service.IBaseMasterService;

@Lazy
@Service
public abstract class AbstractBaseMasterService<T extends IBaseMasterEntity<K>, K extends Serializable, E extends IBaseMasterRepository<T, K>>
	extends AbstractBaseService<T, K, E> implements IBaseMasterService<T, K> {
	
	@Override
	public ResultCodeConstant update(T data) {
		ResultCodeConstant resultCodeConstant = validateData(data);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		T dataTemp  = getRepository().getById(data.getId());
		dataTemp.setCreatedBy(dataTemp.getCreatedBy());
		dataTemp.setCreatedOn(dataTemp.getCreatedOn());
		dataTemp = getRepository().update(data);
		return ResultCodeConstant.SUCCESS;
	}
}
