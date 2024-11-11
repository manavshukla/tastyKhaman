package com.aone.corelibrary.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;

public interface IBaseController<T extends IBaseEntity<K>, K extends Serializable> {
	
	public ResponseEntity<IResponseData<T>> init(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> save(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> update(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> saveOrUpdate(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> saveOrUpdateAll(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> delete(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> getById(RequestData<T,K> requestData);

	public ResponseEntity<IResponseData<T>> getActiveData(RequestData<SearchData<T>, K> requestData);

	public ResponseEntity<IResponseData<T>> getAll(RequestData<SearchData<T>,K> requestData);

}
