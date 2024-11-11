package com.aone.module.salesDetails.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.salesDetails.model.SalesDetails;

public interface ISalesDetailsDao extends IBaseMasterRepository<SalesDetails  , Long>{

	public int deleteBySalesId(long salesId);
}
