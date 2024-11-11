package com.aone.module.servicespackagedetail.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.servicespackagedetail.model.ServicesPackageDetail;

public interface IServicesPackageDetailController extends IBaseMasterController<ServicesPackageDetail, Long> {
	public ResponseEntity<IResponseData<Boolean>> checkCategoryName(@RequestBody RequestData<ServicesPackageDetail,Long> requestData);

}
