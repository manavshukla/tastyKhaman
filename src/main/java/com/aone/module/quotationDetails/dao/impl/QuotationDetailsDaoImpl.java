package com.aone.module.quotationDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.quotationDetails.dao.IQuotationDetailsDao;
import com.aone.module.quotationDetails.model.QuotationDetails;

@Lazy
@Repository("quotationDetailsDaoImpl")
public class QuotationDetailsDaoImpl extends AbstractBaseMasterRepository<QuotationDetails , Long> implements IQuotationDetailsDao {

	@Override
	public Class<QuotationDetails> getClazz() {
		return QuotationDetails.class;
	}

}
