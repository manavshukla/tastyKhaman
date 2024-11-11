package com.aone.module.bankJournals.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.bankJournals.dao.IBankJournalsDao;
import com.aone.module.bankJournals.model.BankJournals;
import com.aone.module.bankJournals.service.IBankJournalsService;

@Lazy
@Service("bankJournalsServiceImpl")
public class BankJournalsServiceImpl extends AbstractBaseMasterService<BankJournals , Long, IBankJournalsDao  >
		implements IBankJournalsService {

	private IBankJournalsDao  bankJournalsDao;

	@Override
	public IBankJournalsDao getRepository() {
		return getBankJournalsDao();
	}

	public IBankJournalsDao getBankJournalsDao() {
		return bankJournalsDao;
	}

	@Autowired
	@Qualifier(value = "bankJournalsDaoImpl")
	public void setBankJournalsDao(IBankJournalsDao bankJournalsDao) {
		this.bankJournalsDao = bankJournalsDao;
	}
	

}
