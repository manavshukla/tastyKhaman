package com.aone.module.services.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.services.dao.IServicesDao;
import com.aone.module.services.model.Services;

@Lazy
@Repository("servicesDaoImpl")
public class ServicesDaoImpl extends AbstractBaseMasterRepository<Services, Long> implements IServicesDao{

	@Override
	public Class<Services> getClazz() {
		return Services.class;
	}

}
