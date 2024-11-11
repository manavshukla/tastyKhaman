package com.aone.module.saleWorkerHelper.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;

public interface ISaleWorkerHelperService  extends IBaseMasterService<SaleWorkerHelper  , Long>{

	public int deleteBySaleId(long saleId);
	
	public List<SaleWorkerHelper> getBySalesId(long salesId);
}
