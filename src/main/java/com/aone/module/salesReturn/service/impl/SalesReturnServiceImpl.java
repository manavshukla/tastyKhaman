package com.aone.module.salesReturn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.salesReturn.dao.ISalesReturnDao;
import com.aone.module.salesReturn.model.SalesReturn;
import com.aone.module.salesReturn.service.ISalesReturnService;

@Lazy
@Service("salesReturnServiceImpl")
public class SalesReturnServiceImpl extends AbstractBaseMasterService<SalesReturn , Long, ISalesReturnDao> implements
		ISalesReturnService {
	
	private ISalesReturnDao salesReturnDao;

	@Override
	public ISalesReturnDao getRepository() {
		return getSalesReturnDao();
	}

	public ISalesReturnDao getSalesReturnDao() {
		return salesReturnDao;
	}

	@Autowired
	@Qualifier(value = "salesReturnDaoImpl")
	public void setSalesReturnDao(ISalesReturnDao salesReturnDao) {
		this.salesReturnDao = salesReturnDao;
	}

}