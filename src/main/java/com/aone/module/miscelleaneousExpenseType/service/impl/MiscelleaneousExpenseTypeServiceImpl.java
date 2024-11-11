package com.aone.module.miscelleaneousExpenseType.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.miscelleaneousExpenseType.dao.IMiscelleaneousExpenseTypeDao;
import com.aone.module.miscelleaneousExpenseType.model.MiscelleaneousExpenseType;
import com.aone.module.miscelleaneousExpenseType.service.IMiscelleaneousExpenseTypeService;

@Lazy
@Service("miscelleaneousExpenseTypeServiceImpl")
public class MiscelleaneousExpenseTypeServiceImpl extends AbstractBaseMasterService<MiscelleaneousExpenseType, Long, IMiscelleaneousExpenseTypeDao> implements
		IMiscelleaneousExpenseTypeService {
	
	private IMiscelleaneousExpenseTypeDao miscelleaneousExpenseTypeDao;

	@Override
	public IMiscelleaneousExpenseTypeDao getRepository() {
		return getMiscelleaneousExpenseTypeDao();
	}

	public IMiscelleaneousExpenseTypeDao getMiscelleaneousExpenseTypeDao() {
		return miscelleaneousExpenseTypeDao;
	}

	@Autowired
	@Qualifier(value = "miscelleaneousExpenseTypeDaoImpl")
	public void setMiscelleaneousExpenseTypeDao(
			IMiscelleaneousExpenseTypeDao miscelleaneousExpenseTypeDao) {
		this.miscelleaneousExpenseTypeDao = miscelleaneousExpenseTypeDao;
	}
}