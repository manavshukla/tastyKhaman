package com.aone.module.userRoleGroupMapping.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.userRoleGroupMapping.dao.IUserRoleGroupMappingDao;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;

@Lazy
@Repository("userRoleGroupMappingDaoImpl")
public class UserRoleGroupMappingDaoImpl extends AbstractBaseMasterRepository<UserRoleGroupMapping, Long> implements IUserRoleGroupMappingDao {

	@Override
	public Class<UserRoleGroupMapping> getClazz() {
		return UserRoleGroupMapping.class;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByUserId(long userId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where userId = :userId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("userId", userId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByContactId(long contactId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where contactId = :contactId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("contactId", contactId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}

}
