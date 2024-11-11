package com.aone.module.purchaseReturnDetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.purchaseReturnDetails.dao.IPurchaseReturnDetailsDao;
import com.aone.module.purchaseReturnDetails.model.PurchaseReturnDetails;

@Lazy
@Repository("purchaseReturnDetailsDaoImpl")
public class PurchaseReturnDetailsDaoImpl extends AbstractBaseMasterRepository<PurchaseReturnDetails , Long> implements IPurchaseReturnDetailsDao {

	@Override
	public Class<PurchaseReturnDetails> getClazz() {
		return PurchaseReturnDetails.class;
	}

}
