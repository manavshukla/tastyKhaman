package com.aone.module.salesThirdParty.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.salesThirdParty.model.SalesThirdParty;

public interface ISalesThirdPartyService  extends IBaseMasterService<SalesThirdParty  , Long>{

	public int deleteBySaleId(long saleId);
	
	public List<SalesThirdParty> getBySalesId(long salesId);
}
