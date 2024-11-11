package com.aone.module.cashJournals.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.cashJournals.dao.ICashJournalsDao;
import com.aone.module.cashJournals.model.CashJournals;
import com.aone.module.cashJournals.service.ICashJournalsService;

@Lazy
@Service("cashJournalsServiceImpl")
public class CashJournalsServiceImpl extends AbstractBaseMasterService<CashJournals, Long, ICashJournalsDao> implements
		ICashJournalsService {
	
	private ICashJournalsDao cashJournalsDao;

	@Override
	public ICashJournalsDao getRepository() {
		return getCashJournalsDao();
	}

	public ICashJournalsDao getCashJournalsDao() {
		return cashJournalsDao;
	}

	@Autowired
	@Qualifier(value = "cashJournalsDaoImpl")
	public void setCashJournalsDao(ICashJournalsDao cashJournalsDao) {
		this.cashJournalsDao = cashJournalsDao;
	}

	
}