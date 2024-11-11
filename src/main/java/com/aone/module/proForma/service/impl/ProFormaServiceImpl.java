package com.aone.module.proForma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.proForma.dao.IProFormaDao;
import com.aone.module.proForma.model.ProForma;
import com.aone.module.proForma.service.IProFormaService;

@Lazy
@Service("proFormaServiceImpl")
public class ProFormaServiceImpl extends AbstractBaseMasterService<ProForma  , Long, IProFormaDao> implements
		IProFormaService {
	
	private IProFormaDao proFormaDao;

	@Override
	public IProFormaDao getRepository() {
		return getProFormaDao();
	}

	public IProFormaDao getProFormaDao() {
		return proFormaDao;
	}

	@Autowired
	@Qualifier(value = "proFormaDaoImpl")
	public void setProFormaDao(IProFormaDao proFormaDao) {
		this.proFormaDao = proFormaDao;
	}
}