package com.aone.corelibrary.dao.impl;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.aone.corelibrary.constant.ExceptionMessage;
import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.corelibrary.model.IBaseMasterEntity;
import com.aone.corelibrary.model.impl.SearchData;

@Lazy
@Repository
@Transactional(readOnly = false)
public abstract class AbstractBaseMasterRepository<T extends IBaseMasterEntity<K>, K extends Serializable> extends AbstractBaseRepository<T, K> implements IBaseMasterRepository<T, K> {

	public AbstractBaseMasterRepository() {

	}

	@Override
	@Transactional(readOnly = false)
	public T save(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		//long createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
		/*if(createdBy == 0) {
			throw new AuthenticationFailedException("Login user not found");
		}*/
		//entity.setCreatedBy(createdBy); 
		entity.setCreatedOn(LocalDateTime.now());
		/* t.setFinancialYear(Login.getFinancialYear().getId()); */
		return super.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public T update(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		
		/*long updatedBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
		if(updatedBy == 0) {
			throw new AuthenticationFailedException("Login user not found");
		}
		
		entity.setUpdatedBy(updatedBy);*/ 
		entity.setUpdatedOn(LocalDateTime.now());
		return super.update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public T saveOrUpdate(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		
		if (entity.getId() == null) {
			return save(entity);
		}
		return update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public List<T> saveOrUpdateAll(Iterator<T> entities) {
		List<T> result = new ArrayList<>();
		if (entities == null || !entities.hasNext()) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		}
		
		while (entities.hasNext()) {
			T entity = entities.next();
			
			if (entity.getId() == null) {
				save(entity);
			} else {
				update(entity);
			}
			result.add(entity);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public int delete(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		
		/*long deletedBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
		if(deletedBy == 0) {
			throw new AuthenticationFailedException("Login user not found");
		}
		
		entity.setDeletedBy(deletedBy); */
		entity.setDeletedOn(LocalDateTime.now());
		return super.delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public int delete(Iterator<T> entities) {
		if (entities == null || !entities.hasNext()) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		}
		/*long deletedBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
		if(deletedBy == 0) {
			throw new AuthenticationFailedException("Login user not found");
		}*/
		int count = 0;
		while (entities.hasNext()) {
			T entity = entities.next();
			//entity.setDeletedBy(deletedBy); 
			entity.setDeletedOn(LocalDateTime.now());
			count += this.delete(entity);
		}
		return count;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByQuery(String whereClause, final Map<String, Object> params) {
		if (whereClause == null || whereClause.trim().length() == 0) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("whereClause"));
		}
		/*long deletedBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
		if(deletedBy == 0) {
			throw new AuthenticationFailedException("Login user not found");
		}*/
		
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted , ");
		queryBuilder.append(" deletedby = :deletedBy , ");
		queryBuilder.append(" deletedOn = :deletedOn ");
		queryBuilder.append(whereClause);
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("deleted", true);
		//query.setParameter("deletedBy", deletedBy);
		query.setParameter("deletedOn", LocalDateTime.now());
		
		for(Map.Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.executeUpdate();
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(K id) {
		Assert.notNull(id, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("id"));
		return super.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getActiveData(SearchData<T> searchData) {
		/*long createdBy = -1;
		if(!isPublicModule()) {
			createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}
		}*/
		TypedQuery<T> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		/*if(!isPublicModule()) {
			query.setParameter("createdBy", createdBy);
		}*/
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long getActiveDataCount(SearchData<T> searchData) {
		//long createdBy = -1;
		if(!isPublicModule()) {
			/*createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}*/
		}
		/*StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_COUNT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e where e.deleted = :deleted");
		TypedQuery<Long> query = getEntityManager().createQuery(queryBuilder.toString(), Long.class);
		query.setParameter("deleted", false);
		return query.getSingleResult();*/
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
//		if(!isPublicModule()) {
//			query.setParameter("createdBy", createdBy);
//		}
		return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAll(SearchData<T> searchData) {
		return super.getAll(searchData);
	}

	@Override
	@Transactional(readOnly = false)
	public List<T> getByFieldName(String fieldName, Object value) {
		return super.getByFieldName(fieldName, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getByQuery(String query) {
		return super.getByQuery(query);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getActiveByQuery(String query) {
		return super.getActiveByQuery(query);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getByQueryData(final Map<String, Object> params, final Map<String, Object> notParams) {
		return super.getByQueryData(params, notParams);
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<T> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
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
		return query;
	}
	
	@Override
	public boolean isPublicModule() {
		return false;
	}

}
