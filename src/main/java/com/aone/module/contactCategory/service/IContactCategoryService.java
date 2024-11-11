package com.aone.module.contactCategory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.contactCategory.model.ContactCategory;

public interface IContactCategoryService  extends IBaseMasterService<ContactCategory , Long>{

	public ResponseEntity<IResponseData<Boolean>> checkContactCategoryName(RequestData<ContactCategory, Long> requestData);

	public List<ContactCategory> getByFieldName(String fieldName, Object value);
}
