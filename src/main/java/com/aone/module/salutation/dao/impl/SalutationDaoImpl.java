package com.aone.module.salutation.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.salutation.dao.ISalutationDao;
import com.aone.module.salutation.model.Salutation;

@Lazy
@Repository("salutationDaoImpl")
public class SalutationDaoImpl extends AbstractBaseMasterRepository<Salutation, Long> implements ISalutationDao {

	@Override
	public Class<Salutation> getClazz() {
		return Salutation.class;
	}

}
