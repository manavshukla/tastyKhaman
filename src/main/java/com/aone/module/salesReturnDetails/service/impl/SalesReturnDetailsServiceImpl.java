package com.aone.module.salesReturnDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.salesReturnDetails.dao.ISalesReturnDetailsDao;
import com.aone.module.salesReturnDetails.model.SalesReturnDetails;
import com.aone.module.salesReturnDetails.service.ISalesReturnDetailsService;

@Lazy
@Service("salesReturnDetailsServiceImpl")
public class SalesReturnDetailsServiceImpl extends AbstractBaseMasterService<SalesReturnDetails   , Long, ISalesReturnDetailsDao> implements
		ISalesReturnDetailsService {
	
	private ISalesReturnDetailsDao salesReturnDetailsDao;

	@Override
	public ISalesReturnDetailsDao getRepository() {
		return getSalesReturnDetailsDao();
	}

	public ISalesReturnDetailsDao getSalesReturnDetailsDao() {
		return salesReturnDetailsDao;
	}

	@Autowired
	@Qualifier(value = "salesReturnDetailsDaoImpl")
	public void setSalesReturnDetailsDao(ISalesReturnDetailsDao salesReturnDetailsDao) {
		this.salesReturnDetailsDao = salesReturnDetailsDao;
	}
	
}