package com.aone.module.category.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.category.model.Category;

public interface ICategoryService extends IBaseMasterService<Category, Long> {

	ResponseEntity<IResponseData<Boolean>> checkCategoryName(RequestData<Category, Long> requestData);
}
