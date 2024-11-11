package com.aone.module.billOfMaterial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.billOfMaterial.dao.IBillOfMaterialDao;
import com.aone.module.billOfMaterial.model.BillOfMaterial;
import com.aone.module.billOfMaterial.service.IBillOfMaterialService;

@Lazy
@Service("billOfMaterialServiceImpl")
public class BillOfMaterialServiceImpl extends AbstractBaseMasterService<BillOfMaterial   , Long, IBillOfMaterialDao   >
		implements IBillOfMaterialService  {

	private IBillOfMaterialDao  billOfMaterialDao;

	@Override
	public IBillOfMaterialDao getRepository() {
		return getBillOfMaterialDao();
	}

	public IBillOfMaterialDao getBillOfMaterialDao() {
		return billOfMaterialDao;
	}

	@Autowired
	@Qualifier(value = "billOfMaterialDaoImpl")
	public void setBillOfMaterialDao(IBillOfMaterialDao billOfMaterialDao) {
		this.billOfMaterialDao = billOfMaterialDao;
	}

}
