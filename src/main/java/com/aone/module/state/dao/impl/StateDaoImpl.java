package com.aone.module.state.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.state.dao.IStateDao;
import com.aone.module.state.model.State;

@Lazy
@Repository("stateDaoImpl")
public class StateDaoImpl extends AbstractBaseMasterRepository<State, Long> implements IStateDao {

	@Override
	public Class<State> getClazz() {
		return State.class;
	}
	
	@Override
	public List<State> getActiveData(SearchData<State> searchData) {
		TypedQuery<State> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		return query.getResultList();
	}
	
	@Override
	public Long getActiveDataCount(SearchData<State> searchData) {
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
		return query.getSingleResult();
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<State> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
		StringBuilder queryBuilder = new StringBuilder(50);
		
		if(isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e ");
		if(!isGetAll) {
			queryBuilder.append(" where ");
			if(isPublicModule()) {
				queryBuilder.append(" e.deleted = :deleted ");
			} else {
				/*queryBuilder.append(" e.createdBy = :createdBy AND ");*/
				queryBuilder.append(" e.deleted = :deleted ");
			}
		}
		if(searchData.getData() != null) {
			State state = searchData.getData();
			if(state.getCountryId() > 0 ) {
				queryBuilder.append(" AND e.countryId = :countryId ");
			}
		}
		if(searchData.getOrderingData() != null && !isCountQuery) {
			queryBuilder.append(" order by e."+searchData.getOrderingData().getColumn());
			if(searchData.getOrderingData().isDescending()) {
				queryBuilder.append(" desc ");
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if(searchData.getPaginationData() != null && !isCountQuery && searchData.getPaginationData().getPageNumber() > 0) {
			query.setFirstResult(searchData.getPaginationData().getRowsPerPage() * (searchData.getPaginationData().getPageNumber() - 1));
			query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
		}
		if(searchData.getData() != null) {
			State state = searchData.getData();
			if(state.getCountryId() > 0 ) {
				query.setParameter("countryId", state.getCountryId());
			}
		}
		return query;
	}

}
