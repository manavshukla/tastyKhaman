package com.aone.module.userRole.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contact.model.Contact;
import com.aone.module.userRole.dao.IUserRoleDao;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRoleGroupDetails.model.UserRoleGroupDetails;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;

@Lazy
@Repository("userRoleDaoImpl")
public class UserRoleDaoImpl extends AbstractBaseMasterRepository<UserRole, Long> implements IUserRoleDao {

	@Override
	public Class<UserRole> getClazz() {
		return UserRole.class;
	}
	
	@Override
	public List<UserRole> getByContactId(long contactId){
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append("select e from ");
		queryBuilder.append(getClazz().getName() + " e ");
		queryBuilder.append(" INNER JOIN " + UserRoleGroupDetails.class.getName() + " urgd on e.id = urgd.userRoleId ");
		queryBuilder.append(" INNER JOIN " + UserRoleGroupMapping.class.getName() + " urgm on urgm.userRoleGroupId = urgd.userRoleGroupId ");
		queryBuilder.append(" INNER JOIN " + Contact.class.getName() + " c on c.id = urgm.contactId ");
		queryBuilder.append(" WHERE c.deleted = :deleted ");
		queryBuilder.append(" AND c.id = :contactId ");
		queryBuilder.append(" AND e.deleted = :deleted ");
		queryBuilder.append(" AND urgd.deleted = :deleted ");
		queryBuilder.append(" AND urgm.deleted = :deleted ");
		queryBuilder.append(" ");
		
		TypedQuery<UserRole> query = getEntityManager().createQuery(queryBuilder.toString(), getClazz());
		query.setParameter("deleted", false);
		query.setParameter("contactId", contactId);
		
		return query.getResultList();
	}

}
