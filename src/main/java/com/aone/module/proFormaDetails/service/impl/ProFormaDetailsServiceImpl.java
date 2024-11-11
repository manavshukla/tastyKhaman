package com.aone.module.proFormaDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.proFormaDetails.dao.IProFormaDetailsDao;
import com.aone.module.proFormaDetails.model.ProFormaDetails;
import com.aone.module.proFormaDetails.service.IProFormaDetailsService;

@Lazy
@Service("proFormaDetailsServiceImpl")
public class ProFormaDetailsServiceImpl extends AbstractBaseMasterService<ProFormaDetails , Long, IProFormaDetailsDao> implements
		IProFormaDetailsService {
	
	private IProFormaDetailsDao proFormaDetailsDao;

	@Override
	public IProFormaDetailsDao getRepository() {
		return getProFormaDetailsDao();
	}

	public IProFormaDetailsDao getProFormaDetailsDao() {
		return proFormaDetailsDao;
	}

	@Autowired
	@Qualifier(value = "proFormaDetailsDaoImpl")
	public void setProFormaDetailsDao(IProFormaDetailsDao proFormaDetailsDao) {
		this.proFormaDetailsDao = proFormaDetailsDao;
	}
}