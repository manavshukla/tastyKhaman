package com.aone.corelibrary.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.aone.corelibrary.constant.ExceptionMessage;
import com.aone.corelibrary.dao.IBaseRepository;
import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.impl.SearchData;

@Lazy
@Repository
@Transactional(readOnly = false)
public abstract class AbstractBaseRepository<T extends IBaseEntity<K>, K extends Serializable> implements IBaseRepository<T, K> {

	protected static final String SELECT_PREFIX = "select e from ";
	protected static final String SELECT_COUNT_PREFIX = "select count (e.id) from ";

	@PersistenceContext
	private EntityManager entityManager;

	public AbstractBaseRepository() {

	}
	
	@Override
	public Connection getConnection() {
		Session session = entityManager.unwrap(Session.class);
		Connection connection = null;
		try {
			connection = session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
		} catch (SQLException e) {
		}
		return connection;
	}

	@Override
	@Transactional(readOnly = false)
	public T save(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		entityManager.persist(entity);
		return entity;
	}
	
	@Override
	@Transactional(readOnly = false)
	public List<T> save(List<T> entities) {
		Assert.notNull(entities, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		entityManager.persist(entities);
		return entities;
	}

	@Override
	@Transactional(readOnly = false)
	public T update(T entity) {
		Assert.notNull(entity, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entity"));
		entityManager.merge(entity);
		return entity;
	}
	
	@Override
	@Transactional(readOnly = false)
	public List<T> update(List<T> entities) {
		Assert.notNull(entities, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		entityManager.merge(entities);
		return entities;
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
		if (entities == null || !entities.hasNext()) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		}
		
		List<T> result = new ArrayList<>();
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
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = true ");
		queryBuilder.append(" where id = " +entity.getId());
		return entityManager.createQuery(queryBuilder.toString()).executeUpdate();
	}
	
	@Override
	@Transactional(readOnly = false)
	public int delete(Iterator<T> entities) {
		Assert.notNull(entities, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("entities"));
		
		Query query = entityManager.createQuery(getDeleteQuery());
		int count = 0;
		while (entities.hasNext()) {
			T entity = entities.next();
			query.setParameter("id", entity.getId());
			count += query.executeUpdate();
		}
		return count;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteByQuery(String whereClause, final Map<String, Object> params) {
		if (whereClause == null || whereClause.trim().length() == 0) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("whereClause"));
		}
		
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(whereClause);
		Query query = entityManager.createQuery(queryBuilder.toString());
		query.setParameter("deleted", true);
		for(Map.Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.executeUpdate();
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(K id) {
		Assert.notNull(id, ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("id"));
		return entityManager.find(getClazz(), id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getActiveData(SearchData<T> searchData) {
		TypedQuery<T> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long getActiveDataCount(SearchData<T> searchData) {
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_COUNT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e where e.deleted = :deleted");
		TypedQuery<Long> query = entityManager.createQuery(queryBuilder.toString(), Long.class);
		query.setParameter("deleted", false);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> getAll(SearchData<T> searchData) {
		return getQueryObject(searchData, true, false, getClazz()).getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long getDataCount(SearchData<T> searchData) {
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_COUNT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e ");
		TypedQuery<Long> query = getQueryObject(searchData, true, true, Long.class);
		query.setParameter("deleted", false);
		return (Long) query.getSingleResult();
	}
	
	protected <R> TypedQuery<R> getQueryObject(SearchData<T> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
		StringBuilder queryBuilder = new StringBuilder(50);
		if(isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e ");
		if(!isGetAll) {
			queryBuilder.append("where e.deleted = :deleted ");
		}
		if(searchData != null && searchData.getOrderingData() != null) {
			queryBuilder.append(" order by e."+searchData.getOrderingData().getColumn());
			if(searchData.getOrderingData().isDescending()) {
				queryBuilder.append(" desc ");
			}
		}
		TypedQuery<R> query = null;
		if(isCountQuery) {
			query = entityManager.createQuery(queryBuilder.toString(), clazz);
		} else {
			query = entityManager.createQuery(queryBuilder.toString(), clazz);
		}
		if(searchData != null && searchData.getPaginationData() != null) {
			query.setFirstResult(searchData.getPaginationData().getRowsPerPage() * (searchData.getPaginationData().getPageNumber() - 1));
			query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
		}
		return query;
	}

	@Override
	@Transactional(readOnly = false)
	public List<T> getByFieldName(String fieldName, Object value) {
		if (fieldName == null || fieldName.trim().length() == 0) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("fieldName"));
		}
		
		if (value == null) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("value"));
		}
		
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e where e.");
		queryBuilder.append(fieldName);
		queryBuilder.append("=:fieldValue");
		return entityManager.createQuery(queryBuilder.toString(), getClazz()).setParameter("fieldValue", value).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getByQuery(String query) {
		if (query == null || query.trim().length() == 0) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("query"));
		}
		return entityManager.createQuery(query, getClazz()).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getActiveByQuery(String query) {
		if (query == null || query.trim().length() == 0) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("query"));
		}
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(query);
		if (queryBuilder.toString().toLowerCase().contains("where")) {
			queryBuilder.append(" AND ");
		} else {
			queryBuilder.append(" WHERE ");
		}
		queryBuilder.append(" deleted = :deleted ");
		TypedQuery<T> queryType = entityManager.createQuery(queryBuilder.toString(), getClazz());
		queryType.setParameter("deleted", false);
		return queryType.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getByQueryData(final Map<String, Object> params, final Map<String, Object> notParams) {
		if (params == null || params.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.PARAMTER_NOT_FOUND.getMessage("params"));
		}
		
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e where ");
		buildQueryAndReturnValues(queryBuilder, params, notParams);
		TypedQuery<T> typedQuery = entityManager.createQuery(queryBuilder.toString(), getClazz());
		setParameterValues(typedQuery, params);
		setParameterValues(typedQuery, notParams);
		return typedQuery.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> checkUniqueDataByField(String fieldName, Object value, String notInFieldName, Object value2) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put(fieldName, value);
		params.put("deleted", false);
		
		Map<String, Object> notParams = new LinkedHashMap<>();
		if(value2 != null) {
			notParams.put(notInFieldName, value2);
		}
		return getByQueryData(params, notParams);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected boolean buildQueryAndReturnValues(StringBuilder queryBuilder, Map<String, Object> params, Map<String, Object> notParams) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			queryBuilder.append(" e.").append(entry.getKey()).append("=:").append(entry.getKey());
			queryBuilder.append(" and ");
		}
		for (Map.Entry<String, Object> entry : notParams.entrySet()) {
			queryBuilder.append(" e.").append(entry.getKey()).append("!=:").append(entry.getKey());
			queryBuilder.append(" and ");
		}
		if(!params.isEmpty()) {
			queryBuilder.setLength(queryBuilder.length() - " and ".length());
		}
		return true;
	}

	protected boolean setParameterValues(TypedQuery<T> typedQuery, Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			typedQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return true;
	}
	
	private String getDeleteQuery() {
		StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = true ");
		queryBuilder.append(" where id = :id ");
		return queryBuilder.toString();
	}
	
	@Override
	public boolean isPublicModule() {
		return false;
	}

	// need to implement order by
	// need to implement unique, will check for name unique fields as well
	// need to implement for count
	// need to implement for pagination
	// add check and util for unique 
	// need to rename T to E and related changes in E as well
	// slf4j integration, with 4 separate file (error, debug, trace, sysout)
	// GUI for API call
}
