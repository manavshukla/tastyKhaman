package com.aone.module.bankJournals.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.bankJournals.dao.IBankJournalsDao;
import com.aone.module.bankJournals.model.BankJournals;

@Lazy
@Repository("bankJournalsDaoImpl")
public class BankJournalsDaoImpl extends AbstractBaseMasterRepository<BankJournals , Long> implements IBankJournalsDao  {

	@Override
	public Class<BankJournals > getClazz() {
		return BankJournals.class;
	}

}
