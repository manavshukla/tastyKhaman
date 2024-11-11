package com.aone.module.servicespackagedetail.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.servicespackagedetail.model.ServicesPackageDetail;

public interface IServicesPackageDetailService {
	ResponseEntity<IResponseData<Boolean>> checkCategoryName(RequestData<ServicesPackageDetail, Long> requestData);
}
