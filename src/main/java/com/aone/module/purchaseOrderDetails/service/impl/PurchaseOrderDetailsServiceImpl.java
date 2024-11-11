package com.aone.module.purchaseOrderDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.purchaseOrderDetails.dao.IPurchaseOrderDetailsDao;
import com.aone.module.purchaseOrderDetails.model.PurchaseOrderDetails;
import com.aone.module.purchaseOrderDetails.service.IPurchaseOrderDetailsService;

@Lazy
@Service("purchaseOrderDetailsServiceImpl")
public class PurchaseOrderDetailsServiceImpl extends AbstractBaseMasterService<PurchaseOrderDetails , Long, IPurchaseOrderDetailsDao> implements
		IPurchaseOrderDetailsService {
	
	private IPurchaseOrderDetailsDao purchaseOrderDetailsDao;

	@Override
	public IPurchaseOrderDetailsDao getRepository() {
		return getPurchaseOrderDetailsDao();
	}

	public IPurchaseOrderDetailsDao getPurchaseOrderDetailsDao() {
		return purchaseOrderDetailsDao;
	}

	@Autowired
	@Qualifier(value = "purchaseOrderDetailsDaoImpl")
	public void setPurchaseOrderDetailsDao(IPurchaseOrderDetailsDao purchaseOrderDetailsDao) {
		this.purchaseOrderDetailsDao = purchaseOrderDetailsDao;
	}
}