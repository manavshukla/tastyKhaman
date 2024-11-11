package com.aone.module.billOfMaterialDetail.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.billOfMaterialDetail.dao.IBillOfMaterialDetailDao;
import com.aone.module.billOfMaterialDetail.model.BillOfMaterialDetail;

@Lazy
@Repository("billOfMaterialDetailDaoImpl")
public class BillOfMaterialDetailDaoImpl extends AbstractBaseMasterRepository<BillOfMaterialDetail, Long> implements IBillOfMaterialDetailDao {

	@Override
	public Class<BillOfMaterialDetail> getClazz() {
		return BillOfMaterialDetail.class;
	}

}
