package com.aone.module.miscelleaneousExpenseType.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.miscelleaneousExpenseType.dao.IMiscelleaneousExpenseTypeDao;
import com.aone.module.miscelleaneousExpenseType.model.MiscelleaneousExpenseType;

@Lazy
@Repository("miscelleaneousExpenseTypeDaoImpl")
public class MiscelleaneousExpenseTypeDaoImpl extends AbstractBaseMasterRepository<MiscelleaneousExpenseType, Long> implements IMiscelleaneousExpenseTypeDao {

	@Override
	public Class<MiscelleaneousExpenseType> getClazz() {
		return MiscelleaneousExpenseType.class;
	}

}
