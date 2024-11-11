package com.aone.module.saleWorkerHelper.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.saleWorkerHelper.dao.ISaleWorkerHelperDao;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;

@Lazy
@Repository("saleWorkerHelperDaoImpl")
public class SaleWorkerHelperDaoImpl extends AbstractBaseMasterRepository<SaleWorkerHelper, Long> implements ISaleWorkerHelperDao {

	@Override
	public Class<SaleWorkerHelper> getClazz() {
		return SaleWorkerHelper.class;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteBySaleId(long saleId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where salesId = :salesId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("salesId", saleId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}
}
