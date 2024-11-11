package com.aone.module.quotation.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.quotation.dao.IQuotationDao;
import com.aone.module.quotation.model.Quotation;

@Lazy
@Repository("quotationDaoImpl")
public class QuotationDaoImpl extends AbstractBaseMasterRepository<Quotation , Long> implements IQuotationDao {

	@Override
	public Class<Quotation> getClazz() {
		return Quotation.class;
	}

}
