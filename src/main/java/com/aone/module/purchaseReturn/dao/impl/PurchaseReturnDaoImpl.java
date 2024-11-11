package com.aone.module.purchaseReturn.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.purchaseReturn.dao.IPurchaseReturnDao;
import com.aone.module.purchaseReturn.model.PurchaseReturn;

@Lazy
@Repository("purchaseReturnDaoImpl")
public class PurchaseReturnDaoImpl extends AbstractBaseMasterRepository<PurchaseReturn , Long> implements IPurchaseReturnDao {

	@Override
	public Class<PurchaseReturn> getClazz() {
		return PurchaseReturn.class;
	}

}
