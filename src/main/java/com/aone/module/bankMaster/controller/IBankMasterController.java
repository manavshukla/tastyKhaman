package com.aone.module.bankMaster.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.bankMaster.model.BankMaster;

public interface IBankMasterController extends IBaseMasterController<BankMaster , Long>{
	public ResponseEntity<IResponseData<Boolean>> checkBankName(@RequestBody RequestData<BankMaster, Long> requestData);
}
