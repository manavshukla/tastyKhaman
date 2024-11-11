package com.aone.module.purchaseDetails.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.purchaseDetails.model.PurchaseDetails;

public interface IPurchaseDetailsDao extends IBaseMasterRepository<PurchaseDetails , Long>{

	public int deleteByPurchaseId(long purchaseId);

}
