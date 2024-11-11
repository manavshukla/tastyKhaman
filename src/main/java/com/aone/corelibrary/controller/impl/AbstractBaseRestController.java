package com.aone.corelibrary.controller.impl;

import java.io.Serializable;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityMethodRole;
import com.aone.config.security.constant.RoleMatcher;
import com.aone.corelibrary.controller.IBaseController;
import com.aone.corelibrary.model.IBaseEntity;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.IBaseService;


public abstract class AbstractBaseRestController<T extends IBaseEntity<K>, K extends Serializable, E extends IBaseService<T, K>>
		implements IBaseController<T, K> {

	@Override
	@RequestMapping(value="/init", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<T>> init(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().init(requestData);
	}
	
	@Override
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "SAVE" }, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> save(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().save(requestData);
	}
	
	@Override
	@RequestMapping(value="/update", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "UPDATE" }, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> update(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().update(requestData);
	}

	@Override
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "SAVE", "UPDATE" }, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> saveOrUpdate(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().saveOrUpdate(requestData);
	}

	@Override
	@RequestMapping(value="/saveOrUpdateAll", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "SAVE", "UPDATE" }, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> saveOrUpdateAll(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().saveOrUpdateAll(requestData);
	}

	@Override
	@RequestMapping(value="/delete", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "DELETE"}, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> delete(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().delete(requestData);
	}

	@Override
	@RequestMapping(value="/getById", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "VIEW"}, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> getById(@RequestBody RequestData<T,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getById(requestData);
	}

	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "VIEW"}, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> getActiveData(@RequestBody RequestData<SearchData<T>, K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getActiveData(requestData);
	}

	@Override
	@RequestMapping(value="/getAll", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@SecurityMethodRole(roleList = { "VIEW_DELETED"}, roleMatcher = RoleMatcher.ALL)
	public @ResponseBody ResponseEntity<IResponseData<T>> getAll(@RequestBody RequestData<SearchData<T>,K> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getAll(requestData);
	}
	
	public abstract E getService();
}
