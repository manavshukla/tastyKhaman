package com.aone.module.userRoleGroupDetails.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.userRoleGroupDetails.dao.IUserRoleGroupDetailsDao;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;

@Lazy
@Repository("userRoleGroupDetailsDaoImpl")
public class UserRoleGroupDetailsDaoImpl extends AbstractBaseMasterRepository<UserRoleGroupDetails, Long> implements IUserRoleGroupDetailsDao {

	@Override
	public Class<UserRoleGroupDetails> getClazz() {
		return UserRoleGroupDetails.class;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByUserRoleGroupId(long userRoleGroupId) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" where userRoleGroupId = :userRoleGroupId");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("userRoleGroupId", userRoleGroupId);
		query.setParameter("deleted", true);
		return query.executeUpdate();
	}

}
