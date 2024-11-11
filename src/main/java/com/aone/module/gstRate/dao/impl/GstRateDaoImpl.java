package com.aone.module.gstRate.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.gstRate.dao.IGstRateDao;
import com.aone.module.gstRate.model.GstRate;

@Lazy
@Repository("gstRateDaoImpl")
public class GstRateDaoImpl extends AbstractBaseMasterRepository<GstRate , Long> implements IGstRateDao {

	@Override
	public Class<GstRate> getClazz() {
		return GstRate.class;
	}
}
