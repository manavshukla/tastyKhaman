package com.aone.module.inOutWard.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.inOutWard.dao.IInOutWardDao;
import com.aone.module.inOutWard.model.InOutWard;

@Lazy
@Repository("inOutWardDaoImpl")
public class InOutWardDaoImpl extends AbstractBaseMasterRepository<InOutWard , Long> implements IInOutWardDao {

	@Override
	public Class<InOutWard> getClazz() {
		return InOutWard.class;
	}

}
