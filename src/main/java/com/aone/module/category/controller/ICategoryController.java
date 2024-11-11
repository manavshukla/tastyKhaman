package com.aone.module.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.category.model.Category;

public interface ICategoryController extends IBaseMasterController<Category, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkCategoryName(@RequestBody RequestData<Category,Long> requestData);
}
