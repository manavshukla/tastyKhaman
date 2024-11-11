package com.aone.module.saleWorkerHelper.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;

public interface ISaleWorkerHelperDao extends IBaseMasterRepository<SaleWorkerHelper  , Long>{

	public int deleteBySaleId(long saleId);

}
