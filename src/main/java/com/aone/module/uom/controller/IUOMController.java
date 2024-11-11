package com.aone.module.uom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.uom.model.UOM;

public interface IUOMController extends IBaseMasterController<UOM, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkUOMCode(@RequestBody RequestData<UOM,Long> requestData);
	
}
