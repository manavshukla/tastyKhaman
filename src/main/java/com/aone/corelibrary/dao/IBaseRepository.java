package com.aone.corelibrary.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.impl.SearchData;

public interface IBaseRepository<T extends IBaseEntity<K>, K extends Serializable> /*extends JpaRepository<T, K>*/ {

	public Class<T> getClazz();
	
	public boolean isPublicModule();

	public T save(T entity);
	
	public List<T> save(List<T> entities);

	public T update(T entity);
	
	public List<T> update(List<T> entities);

	public T saveOrUpdate(T entity);

	public List<T> saveOrUpdateAll(Iterator<T> entities);

	public int delete(T entity);
	
	public int delete(Iterator<T> entities);

	public int deleteByQuery(String whereClause, final Map<String, Object> params);

	public T getById(K id);

	public List<T> getActiveData(SearchData<T> searchData);

	public List<T> getAll(SearchData<T> searchData);
	
	public Long getDataCount(SearchData<T> searchData);
	
	public Long getActiveDataCount(SearchData<T> searchData);

	public List<T> getByFieldName(String fieldName, Object value);

	public List<T> getByQuery(String query);

	public List<T> getActiveByQuery(String query);

	public List<T> getByQueryData(final Map<String, Object> params, final Map<String, Object> notParams);
	
	public List<T> checkUniqueDataByField(String fieldName, Object value, String notInFieldName, Object value2);

	public Connection getConnection();

	
	
	/*public List<T> getFirstPage(IPaginator paginator);

	public List<T> nextPageData(IPaginator paginator);

	public List<T> previousPageData(IPaginator paginator);

	public List<T> getLastRow(IPaginator paginator);

	public long getTotalRowCount(IPaginator paginator);*/
}
