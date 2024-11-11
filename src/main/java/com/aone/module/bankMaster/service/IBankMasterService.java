package com.aone.module.bankMaster.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.bankMaster.model.BankMaster;

public interface IBankMasterService  extends IBaseMasterService<BankMaster  , Long>{
	public ResponseEntity<IResponseData<Boolean>> checkBankName(RequestData<BankMaster,Long> requestData);
}
