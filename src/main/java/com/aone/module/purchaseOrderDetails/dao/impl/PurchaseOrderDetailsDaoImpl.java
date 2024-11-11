package com.aone.module.purchaseOrderDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.purchaseOrderDetails.dao.IPurchaseOrderDetailsDao;
import com.aone.module.purchaseOrderDetails.model.PurchaseOrderDetails;

@Lazy
@Repository("purchaseOrderDetailsDaoImpl")
public class PurchaseOrderDetailsDaoImpl extends AbstractBaseMasterRepository<PurchaseOrderDetails, Long> implements IPurchaseOrderDetailsDao {

	@Override
	public Class<PurchaseOrderDetails > getClazz() {
		return PurchaseOrderDetails.class;
	}
}
