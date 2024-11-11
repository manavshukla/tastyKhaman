package com.aone.module.billOfMaterial.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.billOfMaterial.dao.IBillOfMaterialDao;
import com.aone.module.billOfMaterial.model.BillOfMaterial;

@Lazy
@Repository("billOfMaterialDaoImpl")
public class BillOfMaterialDaoImpl extends AbstractBaseMasterRepository<BillOfMaterial   , Long> implements IBillOfMaterialDao   {

	@Override
	public Class<BillOfMaterial> getClazz() {
		return BillOfMaterial.class;
	}

}
