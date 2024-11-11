package com.aone.module.salesDetails.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.salesDetails.model.SalesDetails;

public interface ISalesDetailsService  extends IBaseMasterService<SalesDetails  , Long>{

	public int deleteBySalesId(long salesId);
	
	public List<SalesDetails> getBySalesId(long salesId);
}
