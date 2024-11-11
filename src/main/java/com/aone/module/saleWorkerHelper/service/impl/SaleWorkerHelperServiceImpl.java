package com.aone.module.saleWorkerHelper.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.saleWorkerHelper.dao.ISaleWorkerHelperDao;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;
import com.aone.module.saleWorkerHelper.service.ISaleWorkerHelperService;

@Lazy
@Service("saleWorkerHelperServiceImpl")
public class SaleWorkerHelperServiceImpl extends AbstractBaseMasterService<SaleWorkerHelper  , Long, ISaleWorkerHelperDao> implements
		ISaleWorkerHelperService {
	
	private ISaleWorkerHelperDao saleWorkerHelperDao;

	@Override
	public ISaleWorkerHelperDao getRepository() {
		return getSaleWorkerHelperDao();
	}

	public ISaleWorkerHelperDao getSaleWorkerHelperDao() {
		return saleWorkerHelperDao;
	}

	@Autowired
	@Qualifier(value = "saleWorkerHelperDaoImpl")
	public void setSaleWorkerHelperDao(ISaleWorkerHelperDao saleWorkerHelperDao) {
		this.saleWorkerHelperDao = saleWorkerHelperDao;
	}

	@Override
	public int deleteBySaleId(long saleId) {
		return getRepository().deleteBySaleId(saleId);
	}
	
	@Override
	public List<SaleWorkerHelper> getBySalesId(long salesId){
		Map<String, Object> params = new HashMap<>();
		params.put("salesId", salesId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
}