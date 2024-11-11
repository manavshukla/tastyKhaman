package com.aone.corelibrary.service;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;

public interface IBaseService<T extends IBaseEntity<K>, K extends Serializable> {

	public ResponseEntity<IResponseData<T>> init(RequestData<T, K> requestData);
	
	public ResponseEntity<IResponseData<T>> save(RequestData<T, K> requestData);
	
	public ResponseEntity<IResponseData<T>> update(RequestData<T, K> requestData);

	public ResponseEntity<IResponseData<T>> saveOrUpdate(RequestData<T, K> requestData);

	public ResponseEntity<IResponseData<T>> saveOrUpdateAll(RequestData<T, K> requestData);

	public ResponseEntity<IResponseData<T>> delete(RequestData<T, K> requestData);

	public ResponseEntity<IResponseData<T>> getById(RequestData<T, K> requestData);

	public ResponseEntity<IResponseData<T>> getActiveData(RequestData<SearchData<T>, K> requestData);

	public ResponseEntity<IResponseData<T>> getAll(RequestData<SearchData<T>,K> requestData);
	
	public ResultCodeConstant save(T data);
	
	public ResultCodeConstant update(T requestData);

	public ResultCodeConstant saveOrUpdate(T requestData);

	public List<T> saveOrUpdateAll(List<T> dataList);

	public Integer delete(T requestData);

	@Deprecated
	public T getById(T requestData);

	public T getById(K id);
	
	public List<T> getActiveData(SearchData<T> requestData);

	public List<T> getAll(SearchData<T> requestData);
	
	public ResultCodeConstant validateData(T entity);
	
	public boolean isSetDefaultRequired();

	public Connection getConnection();


}
