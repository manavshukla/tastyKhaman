package com.aone.module.bomStockDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.bomStockDetails.dao.IBomStockDetailsDao;
import com.aone.module.bomStockDetails.model.BomStockDetails;

@Lazy
@Repository("bomStockDetailsDaoImpl")
public class BomStockDetailsDaoImpl extends AbstractBaseMasterRepository<BomStockDetails    , Long> implements IBomStockDetailsDao   {

	@Override
	public Class<BomStockDetails> getClazz() {
		return BomStockDetails.class;
	}

}
