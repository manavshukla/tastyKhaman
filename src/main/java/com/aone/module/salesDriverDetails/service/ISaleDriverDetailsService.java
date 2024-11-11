package com.aone.module.salesDriverDetails.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;

public interface ISaleDriverDetailsService  extends IBaseMasterService<SaleDriverDetails  , Long>{

	public int deleteBySaleId(long saleId);
	
	public List<SaleDriverDetails> getBySalesId(long salesId);
}
