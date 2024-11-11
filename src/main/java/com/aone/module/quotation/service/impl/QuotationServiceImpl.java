package com.aone.module.quotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.quotation.dao.IQuotationDao;
import com.aone.module.quotation.model.Quotation;
import com.aone.module.quotation.service.IQuotationService;

@Lazy
@Service("quotationServiceImpl")
public class QuotationServiceImpl extends AbstractBaseMasterService<Quotation  , Long, IQuotationDao> implements
		IQuotationService {
	
	private IQuotationDao quotationDao;

	@Override
	public IQuotationDao getRepository() {
		return getQuotationDao();
	}

	public IQuotationDao getQuotationDao() {
		return quotationDao;
	}

	@Autowired
	@Qualifier(value = "quotationDaoImpl")
	public void setQuotationDao(IQuotationDao quotationDao) {
		this.quotationDao = quotationDao;
	}
	
}