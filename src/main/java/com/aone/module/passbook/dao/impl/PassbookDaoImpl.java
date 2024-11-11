package com.aone.module.passbook.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.passbook.dao.IPassbookDao;
import com.aone.module.passbook.model.Passbook;

@Lazy
@Repository("passbookDaoImpl")
public class PassbookDaoImpl extends AbstractBaseMasterRepository<Passbook , Long> implements IPassbookDao  {

	@Override
	public Class<Passbook > getClazz() {
		return Passbook.class;
	}
}
