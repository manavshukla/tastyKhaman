package com.aone.module.bankMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.bankMaster.dao.IBankMasterDao;
import com.aone.module.bankMaster.model.BankMaster;
import com.aone.module.bankMaster.service.IBankMasterService;

@Lazy
@Service("bankMasterServiceImpl")
public class BankMasterServiceImpl extends AbstractBaseMasterService<BankMaster  , Long, IBankMasterDao >
		implements IBankMasterService {

	private IBankMasterDao bankMasterDao;

	@Override
	public IBankMasterDao getRepository() {
		return getBankMasterDao();
	}

	public IBankMasterDao getBankMasterDao() {
		return bankMasterDao;
	}

	@Autowired
	@Qualifier(value = "bankMasterDaoImpl")
	public void setBankMasterDao(IBankMasterDao bankMasterDao) {
		this.bankMasterDao = bankMasterDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkBankName(RequestData<BankMaster, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkBankName("name", requestData.getData()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
}
