package com.aone.module.quotationDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.quotationDetails.dao.IQuotationDetailsDao;
import com.aone.module.quotationDetails.model.QuotationDetails;
import com.aone.module.quotationDetails.service.IQuotationDetailsService;

@Lazy
@Service("quotationDetailsServiceImpl")
public class QuotationDetailsServiceImpl extends AbstractBaseMasterService<QuotationDetails  , Long, IQuotationDetailsDao> implements
		IQuotationDetailsService {
	
	private IQuotationDetailsDao quotationDetailsDao;

	@Override
	public IQuotationDetailsDao getRepository() {
		return getQuotationDetailsDao();
	}

	public IQuotationDetailsDao getQuotationDetailsDao() {
		return quotationDetailsDao;
	}

	@Autowired
	@Qualifier(value = "quotationDetailsDaoImpl")
	public void setQuotationDetailsDao(IQuotationDetailsDao quotationDetailsDao) {
		this.quotationDetailsDao = quotationDetailsDao;
	}

}