package com.aone.module.passbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.passbook.dao.IPassbookDao;
import com.aone.module.passbook.model.Passbook;
import com.aone.module.passbook.service.IPassbookService;

@Lazy
@Service("passbookServiceImpl")
public class PassbookServiceImpl extends AbstractBaseMasterService<Passbook , Long, IPassbookDao  >
		implements IPassbookService {

	private IPassbookDao  passbookDao;

	@Override
	public IPassbookDao getRepository() {
		return getPassbookDao();
	}

	public IPassbookDao getPassbookDao() {
		return passbookDao;
	}

	@Autowired
	@Qualifier(value = "passbookDaoImpl")
	public void setPassbookDao(IPassbookDao passbookDao) {
		this.passbookDao = passbookDao;
	}
}
