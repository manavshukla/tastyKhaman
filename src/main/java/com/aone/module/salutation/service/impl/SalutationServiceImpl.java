package com.aone.module.salutation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.salutation.dao.ISalutationDao;
import com.aone.module.salutation.model.Salutation;
import com.aone.module.salutation.service.ISalutationService;

@Lazy
@Service("salutationServiceImpl")
public class SalutationServiceImpl extends AbstractBaseMasterService<Salutation, Long, ISalutationDao>
		implements ISalutationService {

	private ISalutationDao salutationDao;

	@Override
	public ISalutationDao getRepository() {
		return getSalutationDao();
	}

	public ISalutationDao getSalutationDao() {
		return salutationDao;
	}

	@Autowired
	@Qualifier(value = "salutationDaoImpl")
	public void setSalutationDao(ISalutationDao salutationDao) {
		this.salutationDao = salutationDao;
	}

}