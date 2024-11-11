package com.aone.module.uom.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.uom.model.UOM;

public interface IUOMService  extends IBaseMasterService<UOM, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkUOMName(RequestData<UOM, Long> requestData);
}
