package com.aone.module.userRoleGroup.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.userRoleGroup.dao.IUserRoleGroupDao;
import com.aone.module.userRoleGroup.model.UserRoleGroup;

@Lazy
@Repository("userRoleGroupDaoImpl")
public class UserRoleGroupDaoImpl extends AbstractBaseMasterRepository<UserRoleGroup, Long> implements IUserRoleGroupDao {

	@Override
	public Class<UserRoleGroup> getClazz() {
		return UserRoleGroup.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserRoleGroup> getActiveData(SearchData<UserRoleGroup> searchData) {
		TypedQuery<UserRoleGroup> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		if (searchData != null) {
			UserRoleGroup userRoleGroup = searchData.getData();
			if (userRoleGroup != null) {
				if (userRoleGroup.getName() != null && !userRoleGroup.getName().isEmpty()) {
					query.setParameter("name", "%" + userRoleGroup.getName() + "%");
				}
			}
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Long getActiveDataCount(SearchData<UserRoleGroup> searchData) {
		if (!isPublicModule()) {
		
		}
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
		if (searchData != null) {
			UserRoleGroup userRoleGroup = searchData.getData();
			if (userRoleGroup != null) {
				if (userRoleGroup.getName() != null && !userRoleGroup.getName().isEmpty()) {
					query.setParameter("name", "%" + userRoleGroup.getName() + "%");
				}
			}
		}
		return query.getSingleResult();
	}

	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<UserRoleGroup> searchData, boolean isGetAll, boolean isCountQuery,
			Class<R> clazz) {
		StringBuilder queryBuilder = new StringBuilder(50);

		if (isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e Where 1=1  ");
		if (!isGetAll) {
			if (isPublicModule()) {
				queryBuilder.append("  AND e.deleted = :deleted ");
			} else {
				/* queryBuilder.append(" e.createdBy = :createdBy AND "); */
				if (searchData != null) {
					UserRoleGroup userRoleGroup = searchData.getData();
					if (userRoleGroup != null) {
						if (userRoleGroup.getName() != null && !userRoleGroup.getName().isEmpty()) {
							queryBuilder.append(" AND e.name like :name ");
						}					}
					queryBuilder.append(" AND e.deleted = :deleted ");
				}
			}
		}
		if (searchData != null) {
			if (searchData.getOrderingData() != null && !isCountQuery) {
				queryBuilder.append(" order by e." + searchData.getOrderingData().getColumn());
				if (searchData.getOrderingData().isDescending()) {
					queryBuilder.append(" desc ");
				}
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if (searchData != null) {
			if (searchData.getPaginationData() != null && !isCountQuery) {
				query.setFirstResult(searchData.getPaginationData().getRowsPerPage()
						* (searchData.getPaginationData().getPageNumber() - 1));
				query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
			}
		}
		return query;
	}	
}
