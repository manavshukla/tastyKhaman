package com.aone.module.salesDriverDetails.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.salesDriverDetails.dao.ISaleDriverDetailsDao;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;
import com.aone.module.salesDriverDetails.service.ISaleDriverDetailsService;

@Lazy
@Service("saleDriverDetailsServiceImpl")
public class SaleDriverDetailsServiceImpl extends AbstractBaseMasterService<SaleDriverDetails  , Long, ISaleDriverDetailsDao> implements
		ISaleDriverDetailsService {
	
	private ISaleDriverDetailsDao saleDriverDetailsDao;

	@Override
	public ISaleDriverDetailsDao getRepository() {
		return getSaleDriverDetailsDao();
	}

	public ISaleDriverDetailsDao getSaleDriverDetailsDao() {
		return saleDriverDetailsDao;
	}

	@Autowired
	@Qualifier(value = "saleDriverDetailsDaoImpl")
	public void setSaleDriverDetailsDao(ISaleDriverDetailsDao saleDriverDetailsDao) {
		this.saleDriverDetailsDao = saleDriverDetailsDao;
	}
	
	public int deleteBySaleId(long saleId) {
		return getRepository().deleteBySaleId(saleId);
	}
	
	@Override
	public List<SaleDriverDetails> getBySalesId(long salesId){
		Map<String, Object> params = new HashMap<>();
		params.put("salesId", salesId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
}