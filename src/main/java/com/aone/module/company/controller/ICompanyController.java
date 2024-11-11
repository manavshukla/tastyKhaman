package com.aone.module.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.company.model.Company;

public interface ICompanyController extends IBaseMasterController<Company, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkCompanyName(@RequestBody RequestData<Company,Long> requestData);
}
