package com.aone.module.purchaseReturnDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.purchaseReturnDetails.dao.IPurchaseReturnDetailsDao;
import com.aone.module.purchaseReturnDetails.model.PurchaseReturnDetails;
import com.aone.module.purchaseReturnDetails.service.IPurchaseReturnDetailsService;

@Lazy
@Service("purchaseReturnDetailsServiceImpl")
public class PurchaseReturnDetailsServiceImpl extends AbstractBaseMasterService<PurchaseReturnDetails , Long, IPurchaseReturnDetailsDao> implements
		IPurchaseReturnDetailsService {
	
	private IPurchaseReturnDetailsDao purchaseReturnDetailsDao;

	@Override
	public IPurchaseReturnDetailsDao getRepository() {
		return getPurchaseReturnDetailsDao();
	}

	public IPurchaseReturnDetailsDao getPurchaseReturnDetailsDao() {
		return purchaseReturnDetailsDao;
	}

	@Autowired
	@Qualifier(value = "purchaseReturnDetailsDaoImpl")
	public void setPurchaseReturnDetailsDao(IPurchaseReturnDetailsDao purchaseReturnDetailsDao) {
		this.purchaseReturnDetailsDao = purchaseReturnDetailsDao;
	}

}