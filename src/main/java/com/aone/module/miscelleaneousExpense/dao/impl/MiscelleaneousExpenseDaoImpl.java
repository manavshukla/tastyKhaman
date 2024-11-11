package com.aone.module.miscelleaneousExpense.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.miscelleaneousExpense.dao.IMiscelleaneousExpenseDao;
import com.aone.module.miscelleaneousExpense.model.MiscelleaneousExpense;

@Lazy
@Repository("miscelleaneousExpenseDaoImpl")
public class MiscelleaneousExpenseDaoImpl extends AbstractBaseMasterRepository<MiscelleaneousExpense, Long> implements IMiscelleaneousExpenseDao {

	@Override
	public Class<MiscelleaneousExpense> getClazz() {
		return MiscelleaneousExpense.class;
	}

}
