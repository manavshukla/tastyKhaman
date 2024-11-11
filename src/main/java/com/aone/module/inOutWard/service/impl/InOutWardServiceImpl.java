package com.aone.module.inOutWard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.inOutWard.dao.IInOutWardDao;
import com.aone.module.inOutWard.model.InOutWard;
import com.aone.module.inOutWard.service.IInOutWardService;

@Lazy
@Service("inOutWardServiceImpl")
public class InOutWardServiceImpl extends AbstractBaseMasterService<InOutWard , Long, IInOutWardDao> implements
		IInOutWardService {
	
	private IInOutWardDao inOutWardDao;

	@Override
	public IInOutWardDao getRepository() {
		return getInOutWardDao();
	}

	public IInOutWardDao getInOutWardDao() {
		return inOutWardDao;
	}

	@Autowired
	@Qualifier(value = "inOutWardDaoImpl")
	public void setInOutWardDao(IInOutWardDao inOutWardDao) {
		this.inOutWardDao = inOutWardDao;
	}
}