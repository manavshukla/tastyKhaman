package com.aone.module.purchaseOrder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.purchaseOrder.dao.IPurchaseOrderDao;
import com.aone.module.purchaseOrder.model.PurchaseOrder;
import com.aone.module.purchaseOrder.service.IPurchaseOrderService;

@Lazy
@Service("purchaseOrderServiceImpl")
public class PurchaseOrderServiceImpl extends AbstractBaseMasterService<PurchaseOrder , Long, IPurchaseOrderDao> implements
		IPurchaseOrderService {
	
	private IPurchaseOrderDao purchaseOrderDao;

	@Override
	public IPurchaseOrderDao getRepository() {
		return getPurchaseOrderDao();
	}

	public IPurchaseOrderDao getPurchaseOrderDao() {
		return purchaseOrderDao;
	}

	@Autowired
	@Qualifier(value = "purchaseOrderDaoImpl")
	public void setPurchaseOrderDao(IPurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}
}