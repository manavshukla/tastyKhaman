package com.aone.module.bomStockDetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.bomStockDetails.dao.IBomStockDetailsDao;
import com.aone.module.bomStockDetails.model.BomStockDetails;
import com.aone.module.bomStockDetails.service.IBomStockDetailsService;

@Lazy
@Service("bomStockDetailsServiceImpl")
public class BomStockDetailsServiceImpl extends AbstractBaseMasterService<BomStockDetails    , Long, IBomStockDetailsDao   >
		implements IBomStockDetailsService  {

	private IBomStockDetailsDao  bomStockDetailsDao;

	@Override
	public IBomStockDetailsDao getRepository() {
		return getBomStockDetailsDao();
	}

	public IBomStockDetailsDao getBomStockDetailsDao() {
		return bomStockDetailsDao;
	}

	@Autowired
	@Qualifier(value = "bomStockDetailsDaoImpl")
	public void setBomStockDetailsDao(IBomStockDetailsDao bomStockDetailsDao) {
		this.bomStockDetailsDao = bomStockDetailsDao;
	}

}
