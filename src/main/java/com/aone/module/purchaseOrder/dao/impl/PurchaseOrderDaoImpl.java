package com.aone.module.purchaseOrder.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.purchaseOrder.dao.IPurchaseOrderDao;
import com.aone.module.purchaseOrder.model.PurchaseOrder;

@Lazy
@Repository("purchaseOrderDaoImpl")
public class PurchaseOrderDaoImpl extends AbstractBaseMasterRepository<PurchaseOrder , Long> implements IPurchaseOrderDao {

	@Override
	public Class<PurchaseOrder > getClazz() {
		return PurchaseOrder.class;
	}

}
