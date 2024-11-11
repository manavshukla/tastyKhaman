package com.aone.module.city.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.city.dao.ICityDao;
import com.aone.module.city.model.City;

@Lazy
@Repository("cityDaoImpl")
public class CityDaoImpl extends AbstractBaseMasterRepository<City, Long> implements ICityDao {

	@Override
	public Class<City> getClazz() {
		return City.class;
	}

	@Override
	public Long getActiveDataCount(SearchData<City> searchData) {
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
		return query.getSingleResult();
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<City> searchData, boolean isGetAll, boolean isCountQuery,
			Class<R> clazz) {
		StringBuilder queryBuilder = new StringBuilder(50);

		if (isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e ");
		if (!isGetAll) {
			queryBuilder.append(" where ");
			if (isPublicModule()) {
				queryBuilder.append(" e.deleted = :deleted ");
			} else {
				/* queryBuilder.append(" e.createdBy = :createdBy AND "); */
				queryBuilder.append(" e.deleted = :deleted ");
			}
		}
		if (searchData.getData() != null) {
			City city = searchData.getData();
			if (city.getStateId() > 0) {
				queryBuilder.append(" AND e.stateId= :stateId ");
			}
		}
		if (searchData.getOrderingData() != null && !isCountQuery) {
			queryBuilder.append(" order by e." + searchData.getOrderingData().getColumn());
			if (searchData.getOrderingData().isDescending()) {
				queryBuilder.append(" desc ");
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if (searchData.getPaginationData() != null && !isCountQuery
				&& searchData.getPaginationData().getPageNumber() > 0) {
			query.setFirstResult(searchData.getPaginationData().getRowsPerPage()
					* (searchData.getPaginationData().getPageNumber() - 1));
			query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
		}
		if (searchData.getData() != null) {
			City city= searchData.getData();
			if (city.getStateId() > 0) {
				query.setParameter("stateId", city.getStateId());
			}
		}
		return query;
	}

}
