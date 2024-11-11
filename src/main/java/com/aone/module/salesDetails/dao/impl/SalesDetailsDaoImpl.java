package com.aone.module.salesDetails.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.salesDetails.dao.ISalesDetailsDao;
import com.aone.module.salesDetails.model.SalesDetails;

@Lazy
@Repository("salesDetailsDaoImpl")
public class SalesDetailsDaoImpl extends AbstractBaseMasterRepository<SalesDetails , Long> implements ISalesDetailsDao {

	@Override
	public Class<SalesDetails> getClazz() {
		return SalesDetails.class;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteBySalesId(long salesId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where salesId = :salesId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("salesId", salesId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}

}
