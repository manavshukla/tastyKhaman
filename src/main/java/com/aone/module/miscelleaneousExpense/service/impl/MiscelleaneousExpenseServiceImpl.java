package com.aone.module.miscelleaneousExpense.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.miscelleaneousExpense.dao.IMiscelleaneousExpenseDao;
import com.aone.module.miscelleaneousExpense.model.MiscelleaneousExpense;
import com.aone.module.miscelleaneousExpense.service.IMiscelleaneousExpenseService;

@Lazy
@Service("miscelleaneousExpenseServiceImpl")
public class MiscelleaneousExpenseServiceImpl extends AbstractBaseMasterService<MiscelleaneousExpense, Long, IMiscelleaneousExpenseDao> implements
		IMiscelleaneousExpenseService {
	
	private IMiscelleaneousExpenseDao miscelleaneousExpenseDao;

	@Override
	public IMiscelleaneousExpenseDao getRepository() {
		return getMiscelleaneousExpenseDao();
	}

	public IMiscelleaneousExpenseDao getMiscelleaneousExpenseDao() {
		return miscelleaneousExpenseDao;
	}

	@Autowired
	@Qualifier(value = "miscelleaneousExpenseDaoImpl")
	public void setMiscelleaneousExpenseDao(
			IMiscelleaneousExpenseDao miscelleaneousExpenseDao) {
		this.miscelleaneousExpenseDao = miscelleaneousExpenseDao;
	}
}
