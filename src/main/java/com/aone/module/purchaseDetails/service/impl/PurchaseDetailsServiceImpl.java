package com.aone.module.purchaseDetails.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.purchaseDetails.dao.IPurchaseDetailsDao;
import com.aone.module.purchaseDetails.model.PurchaseDetails;
import com.aone.module.purchaseDetails.service.IPurchaseDetailsService;

@Lazy
@Service("purchaseDetailsServiceImpl")
public class PurchaseDetailsServiceImpl extends AbstractBaseMasterService<PurchaseDetails , Long, IPurchaseDetailsDao> implements
		IPurchaseDetailsService {
	
	private IPurchaseDetailsDao purchaseDetailsDao;

	@Override
	public IPurchaseDetailsDao getRepository() {
		return getPurchaseDetailsDao();
	}

	public IPurchaseDetailsDao getPurchaseDetailsDao() {
		return purchaseDetailsDao;
	}

	@Autowired
	@Qualifier(value = "purchaseDetailsDaoImpl")
	public void setPurchaseDetailsDao(IPurchaseDetailsDao purchaseDetailsDao) {
		this.purchaseDetailsDao = purchaseDetailsDao;
	}
	
	@Override
	public List<PurchaseDetails> getByPurchaseId(long purchaseId){
		Map<String, Object> params = new HashMap<>();
		params.put("purchaseId", purchaseId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
	
	@Override
	public int deleteByPurchaseId(long purchaseId){
		return getRepository().deleteByPurchaseId(purchaseId);
	}
	
}