package com.aone.module.proForma.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.proForma.dao.IProFormaDao;
import com.aone.module.proForma.model.ProForma;

@Lazy
@Repository("proFormaDaoImpl")
public class ProFormaDaoImpl extends AbstractBaseMasterRepository<ProForma  , Long> implements IProFormaDao {

	@Override
	public Class<ProForma > getClazz() {
		return ProForma.class;
	}
}
