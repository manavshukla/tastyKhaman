package com.aone.module.salesThirdParty.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.salesThirdParty.model.SalesThirdParty;

public interface ISalesThirdPartyDao extends IBaseMasterRepository<SalesThirdParty  , Long>{

	public int deleteBySaleId(long saleId);

}
