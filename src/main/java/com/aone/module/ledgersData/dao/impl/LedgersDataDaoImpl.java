package com.aone.module.ledgersData.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.ledgersData.dao.ILedgersDataDao;
import com.aone.module.ledgersData.model.LedgersData;

@Lazy
@Repository("ledgersDataDaoImpl")
public class LedgersDataDaoImpl extends AbstractBaseMasterRepository<LedgersData, Long> implements ILedgersDataDao {

	@Override
	public Class<LedgersData> getClazz() {
		return LedgersData.class;
	}

}
