package com.aone.module.purchaseDetails.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.purchaseDetails.dao.IPurchaseDetailsDao;
import com.aone.module.purchaseDetails.model.PurchaseDetails;

@Lazy
@Repository("purchaseDetailsDaoImpl")
public class PurchaseDetailsDaoImpl extends AbstractBaseMasterRepository<PurchaseDetails, Long> implements IPurchaseDetailsDao {

	@Override
	public Class<PurchaseDetails> getClazz() {
		return PurchaseDetails.class;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByPurchaseId(long purchaseId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where purchaseId = :purchaseId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("purchaseId", purchaseId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}

}
