package com.aone.module.salesReturn.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.salesReturn.dao.ISalesReturnDao;
import com.aone.module.salesReturn.model.SalesReturn;

@Lazy
@Repository("salesReturnDaoImpl")
public class SalesReturnDaoImpl extends AbstractBaseMasterRepository<SalesReturn  , Long> implements ISalesReturnDao {

	@Override
	public Class<SalesReturn> getClazz() {
		return SalesReturn.class;
	}

}
