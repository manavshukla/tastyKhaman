package com.aone.module.uom.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.uom.dao.IUOMDao;
import com.aone.module.uom.model.UOM;

@Lazy
@Repository("uomDaoImpl")
public class UOMDaoImpl extends AbstractBaseMasterRepository<UOM, Long> implements IUOMDao {

	@Override
	public Class<UOM> getClazz() {
		return UOM.class;
	}

}
