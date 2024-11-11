package com.aone.module.servicespackagedetail.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.servicespackagedetail.dao.IServicesPackageDetailDao;
import com.aone.module.servicespackagedetail.model.ServicesPackageDetail;

@Lazy
@Repository("servicesPackageDetailDaoImpl")
public class ServicesPackageDetailDaoImpl extends AbstractBaseMasterRepository<ServicesPackageDetail, Long> implements IServicesPackageDetailDao {

	@Override
	public Class<ServicesPackageDetail> getClazz() {
		return ServicesPackageDetail.class;
	}

}
