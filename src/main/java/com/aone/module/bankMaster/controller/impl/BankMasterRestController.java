package com.aone.module.bankMaster.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.bankMaster.controller.IBankMasterController;
import com.aone.module.bankMaster.model.BankMaster;
import com.aone.module.bankMaster.service.IBankMasterService;

@RestController
@RequestMapping("/rest/bankMaster")
public class BankMasterRestController extends AbstractBaseMasterRestController<BankMaster , Long, IBankMasterService> implements IBankMasterController {

	private IBankMasterService bankMasterService;
	
	@Override
	@RequestMapping(value="/checkBankName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkBankName(@RequestBody RequestData<BankMaster,Long> requestData) {
		return getService().checkBankName(requestData);
	}
	
	@Override
	public IBankMasterService getService() {
		return getBankMasterService();
	}

	public IBankMasterService getBankMasterService() {
		return bankMasterService;
	}

	@Autowired
	@Qualifier(value="bankMasterServiceImpl")
	public void setBankMasterService(IBankMasterService bankMasterService) {
		this.bankMasterService = bankMasterService;
	}
}
