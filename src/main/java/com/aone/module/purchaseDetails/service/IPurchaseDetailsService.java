package com.aone.module.purchaseDetails.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.purchaseDetails.model.PurchaseDetails;

public interface IPurchaseDetailsService  extends IBaseMasterService<PurchaseDetails , Long>{

	public List<PurchaseDetails> getByPurchaseId(long purchaseId);

	public int deleteByPurchaseId(long purchaseId);

}
