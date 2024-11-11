package com.aone.module.billOfMaterialDetail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.billOfMaterialDetail.dao.IBillOfMaterialDetailDao;
import com.aone.module.billOfMaterialDetail.model.BillOfMaterialDetail;
import com.aone.module.billOfMaterialDetail.service.IBillOfMaterialDetailService;

@Lazy
@Service("billOfMaterialDetailServiceImpl")
public class BillOfMaterialDetailServiceImpl extends AbstractBaseMasterService<BillOfMaterialDetail , Long, IBillOfMaterialDetailDao >
		implements IBillOfMaterialDetailService {

	private IBillOfMaterialDetailDao billOfMaterialDetailDao;

	@Override
	public IBillOfMaterialDetailDao getRepository() {
		return getBillOfMaterialDetailDao();
	}

	public IBillOfMaterialDetailDao getBillOfMaterialDetailDao() {
		return billOfMaterialDetailDao;
	}

	@Autowired
	@Qualifier(value = "billOfMaterialDetailDaoImpl")
	public void setBillOfMaterialDetailDao(IBillOfMaterialDetailDao billOfMaterialDetailDao) {
		this.billOfMaterialDetailDao = billOfMaterialDetailDao;
	}
}
