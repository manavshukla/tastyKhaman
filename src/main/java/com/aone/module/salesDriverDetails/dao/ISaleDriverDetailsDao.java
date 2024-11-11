package com.aone.module.salesDriverDetails.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;

public interface ISaleDriverDetailsDao extends IBaseMasterRepository<SaleDriverDetails  , Long>{

	public int deleteBySaleId(long saleId);

}
