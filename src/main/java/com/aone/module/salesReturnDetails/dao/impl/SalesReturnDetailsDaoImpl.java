package com.aone.module.salesReturnDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.salesReturnDetails.dao.ISalesReturnDetailsDao;
import com.aone.module.salesReturnDetails.model.SalesReturnDetails;

@Lazy
@Repository("salesReturnDetailsDaoImpl")
public class SalesReturnDetailsDaoImpl extends AbstractBaseMasterRepository<SalesReturnDetails  , Long> implements ISalesReturnDetailsDao {

	@Override
	public Class<SalesReturnDetails> getClazz() {
		return SalesReturnDetails.class;
	}

}
