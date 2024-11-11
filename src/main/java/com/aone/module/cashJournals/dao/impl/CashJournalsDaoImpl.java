package com.aone.module.cashJournals.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.cashJournals.dao.ICashJournalsDao;
import com.aone.module.cashJournals.model.CashJournals;

@Lazy
@Repository("cashJournalsDaoImpl")
public class CashJournalsDaoImpl extends AbstractBaseMasterRepository<CashJournals, Long> implements ICashJournalsDao {

	@Override
	public Class<CashJournals> getClazz() {
		return CashJournals.class;
	}

}
