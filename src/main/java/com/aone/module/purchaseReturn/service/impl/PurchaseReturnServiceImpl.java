package com.aone.module.purchaseReturn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.purchaseReturn.dao.IPurchaseReturnDao;
import com.aone.module.purchaseReturn.model.PurchaseReturn;
import com.aone.module.purchaseReturn.service.IPurchaseReturnService;

@Lazy
@Service("purchaseReturnServiceImpl")
public class PurchaseReturnServiceImpl extends AbstractBaseMasterService<PurchaseReturn , Long, IPurchaseReturnDao> implements
		IPurchaseReturnService {
	
	private IPurchaseReturnDao purchaseReturnDao;

	@Override
	public IPurchaseReturnDao getRepository() {
		return getPurchaseReturnDao();
	}

	public IPurchaseReturnDao getPurchaseReturnDao() {
		return purchaseReturnDao;
	}


	@Autowired
	@Qualifier(value = "purchaseReturnDaoImpl")
	public void setPurchaseReturnDao(IPurchaseReturnDao purchaseReturnDao) {
		this.purchaseReturnDao = purchaseReturnDao;
	}

}