package com.aone.module.servicescategory.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.servicescategory.dao.IServicesCategoryDao;
import com.aone.module.servicescategory.model.ServicesCategory;

@Lazy
@Repository("servicesCategoryDaoImpl")
public class ServicesCategoryDaoImpl extends AbstractBaseMasterRepository<ServicesCategory, Long> implements IServicesCategoryDao{

	@Override
	public Class<ServicesCategory> getClazz() {
		return ServicesCategory.class;
	}

}
