package com.aone.module.proFormaDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.proFormaDetails.dao.IProFormaDetailsDao;
import com.aone.module.proFormaDetails.model.ProFormaDetails;

@Lazy
@Repository("proFormaDetailsDaoImpl")
public class ProFormaDetailsDaoImpl extends AbstractBaseMasterRepository<ProFormaDetails  , Long> implements IProFormaDetailsDao {

	@Override
	public Class<ProFormaDetails > getClazz() {
		return ProFormaDetails.class;
	}
}
