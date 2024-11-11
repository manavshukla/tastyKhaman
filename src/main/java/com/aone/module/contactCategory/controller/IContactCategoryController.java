package com.aone.module.contactCategory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.contactCategory.model.ContactCategory;

public interface IContactCategoryController extends IBaseMasterController<ContactCategory , Long>{

	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkContactCategoryName(@RequestBody RequestData<ContactCategory,Long> requestData);
}
