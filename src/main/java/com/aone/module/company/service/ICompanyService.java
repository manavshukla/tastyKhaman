package com.aone.module.company.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.company.model.Company;

public interface ICompanyService extends IBaseMasterService<Company, Long> {

	ResponseEntity<IResponseData<Boolean>> checkCompanyName(RequestData<Company, Long> requestData);
}
