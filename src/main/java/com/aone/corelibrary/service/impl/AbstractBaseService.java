package com.aone.corelibrary.service.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.commons.exceptions.OperationFailedException;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.dao.IBaseRepository;
import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.IBaseService;

@Lazy
@Service
public abstract class AbstractBaseService<T extends IBaseEntity<K>, K extends Serializable, E extends IBaseRepository<T, K>>
		implements IBaseService<T, K> {

	@Override
	public Connection getConnection() {
		return getRepository().getConnection();
	}
	
	@Override
	public ResponseEntity<IResponseData<T>> init(RequestData<T,K> requestData) {
		IResponseData<T> responseData = new ResponseData<>(requestData.getData(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<T>> save(RequestData<T,K> requestData) {
		ResultCodeConstant resultCodeConstant = validateData(requestData.getData());
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<T> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		IResponseData<T> responseData = new ResponseData<>(getRepository().save(requestData.getData()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<T>> update(RequestData<T,K> requestData) {
		ResultCodeConstant resultCodeConstant = validateData(requestData.getData());
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<T> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		IResponseData<T> responseData = new ResponseData<>(getRepository().update(requestData.getData()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<T>> saveOrUpdate(RequestData<T,K> requestData) {
		ResultCodeConstant resultCodeConstant = validateData(requestData.getData());
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<T> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		IResponseData<T> responseData = new ResponseData<>(getRepository().saveOrUpdate(requestData.getData()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<T>> saveOrUpdateAll(RequestData<T,K> requestData) {
		// check if list is empty then return the result code with empty list message
		List<T> dataList = requestData.getDataList();
		if(dataList == null  || dataList.isEmpty()) {
			IResponseData<T> responseData = new ResponseData<>(requestData.getDataList(), ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		
		// validate all the data 
		for(T data : dataList) {
			ResultCodeConstant resultCodeConstant = validateData(data);
			if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
				IResponseData<T> responseData = new ResponseData<>(requestData.getData(), resultCodeConstant);
				responseData.setRequestToken(requestData.getRequestToken());
				return new ResponseEntity<>(responseData, HttpStatus.OK);
			}
		}
		
		// save the data list
		IResponseData<T> responseData = new ResponseData<>(getRepository().saveOrUpdateAll(requestData.getDataList().iterator()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<T>> delete(RequestData<T,K> requestData) {
		int count = getRepository().delete(requestData.getData());
		if(count <= 0 ) {
			throw new OperationFailedException("Error occured while deleting the data");
		}
		IResponseData<T> responseData = new ResponseData<>(requestData.getData(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<T>> getById(RequestData<T,K> requestData) {
		if(requestData.getId() == null) {
			IResponseData<T> responseData = new ResponseData<>(requestData.getData(), ResultCodeConstant.PARAMETER_NOT_FOUND);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		T data = getRepository().getById(requestData.getId());
		if(data != null) {
			data.setDefaultValueForObject();
		}
		IResponseData<T> responseData = new ResponseData<>(data, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<T>> getActiveData(RequestData<SearchData<T>,K> requestData) {
		List<T> dataList = getRepository().getActiveData(requestData.getData());
		if(isSetDefaultRequired()) {
			for(T data : dataList) {
				data.setDefaultValueForObject();
			}
		}
		IResponseData<T> responseData = new ResponseData<>(dataList, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		responseData.setTotalRecords(getRepository().getActiveDataCount(requestData.getData()));
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<T>> getAll(RequestData<SearchData<T>,K> requestData) {
		IResponseData<T> responseData = new ResponseData<>(getRepository().getAll(requestData.getData()), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant save(T data) {
		ResultCodeConstant resultCodeConstant = validateData(data);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		data = getRepository().save(data);
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResultCodeConstant update(T data) {
		ResultCodeConstant resultCodeConstant = validateData(data);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		data = getRepository().update(data);
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResultCodeConstant saveOrUpdate(T data) {
		ResultCodeConstant resultCodeConstant = validateData(data);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			return resultCodeConstant;
		}
		data = getRepository().saveOrUpdate(data);
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> dataList) {
		// check if list is empty then return the result code with empty list message
		if(dataList == null  || dataList.isEmpty()) {
			return Collections.emptyList();
		}
		
		// validate all the data 
		for(T data : dataList) {
			ResultCodeConstant resultCodeConstant = validateData(data);
			if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
				return Collections.emptyList();
			}
		}
		
		// save the data list
		return getRepository().saveOrUpdateAll(dataList.iterator());
	}

	@Override
	public Integer delete(T data) {
		int count = getRepository().delete(data);
		if(count <= 0 ) {
			throw new OperationFailedException("Error occured while deleting the data");
		}
		return count;
	}

	@Deprecated
	@Override
	public T getById(T data) {
		if(data.getId() == null) {
			return null;
		}
		data = getRepository().getById(data.getId());
		if(isSetDefaultRequired()) {
			data.setDefaultValueForObject();
		}
		return data;
	}
	
	@Override
	public T getById(K id) {
		if(id == null) {
			return null;
		}
		T data = getRepository().getById(id);
		if( data != null) {
			data.setDefaultValueForObject();
		}
		return data;
	}

	@Override
	public List<T> getActiveData(SearchData<T> searchData) {
		return getRepository().getActiveData(searchData);
	}

	@Override
	public List<T> getAll(SearchData<T> searchData) {
		return getRepository().getAll(searchData);
	}
	
	
	@Override
	public ResultCodeConstant validateData(T entity) {
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public boolean isSetDefaultRequired() {
		return false;
	}

	public abstract E getRepository();
}
