package com.aone.module.salesThirdParty.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.salesThirdParty.dao.ISalesThirdPartyDao;
import com.aone.module.salesThirdParty.model.SalesThirdParty;

@Lazy
@Repository("salesThirdPartyDaoImpl")
public class SalesThirdPartyDaoImpl extends AbstractBaseMasterRepository<SalesThirdParty, Long> implements ISalesThirdPartyDao {

	@Override
	public Class<SalesThirdParty> getClazz() {
		return SalesThirdParty.class;
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
