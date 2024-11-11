package com.aone.module.saleWorkerHelper.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.saleWorkerHelper.controller.ISaleWorkerHelperController;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;
import com.aone.module.saleWorkerHelper.service.ISaleWorkerHelperService;

@RestController
@RequestMapping("/rest/saleWorkerHelper")
public class SaleWorkerHelperRestController extends AbstractBaseMasterRestController<SaleWorkerHelper  , Long, ISaleWorkerHelperService> implements ISaleWorkerHelperController {
	
	private ISaleWorkerHelperService saleWorkerHelperService;
	
	@Override
	public ISaleWorkerHelperService getService() {
		return getSaleWorkerHelperService();
	}

	public ISaleWorkerHelperService getSaleWorkerHelperService() {
		return saleWorkerHelperService;
	}

	@Autowired        
	@Qualifier(value="saleWorkerHelperServiceImpl")
	public void setSaleWorkerHelperService(ISaleWorkerHelperService saleWorkerHelperService) {
		this.saleWorkerHelperService = saleWorkerHelperService;
	}
}
