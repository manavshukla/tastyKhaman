package com.aone.module.ledgersData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.ledgersData.dao.ILedgersDataDao;
import com.aone.module.ledgersData.model.LedgersData;
import com.aone.module.ledgersData.service.ILedgersDataService;

@Lazy
@Service("ledgersDataServiceImpl")
public class LedgersDataServiceImpl extends AbstractBaseMasterService<LedgersData, Long, ILedgersDataDao>
		implements ILedgersDataService {

	private ILedgersDataDao ledgersDataDao;

	@Override
	public ILedgersDataDao getRepository() {
		return getLedgersDataDao();
	}

	public ILedgersDataDao getLedgersDataDao() {
		return ledgersDataDao;
	}

	@Autowired
	@Qualifier(value = "ledgersDataDaoImpl")
	public void setLedgersDataDao(ILedgersDataDao ledgersDataDao) {
		this.ledgersDataDao = ledgersDataDao;
	}

}