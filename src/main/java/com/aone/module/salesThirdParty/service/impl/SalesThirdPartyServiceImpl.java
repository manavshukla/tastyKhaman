package com.aone.module.salesThirdParty.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.salesThirdParty.dao.ISalesThirdPartyDao;
import com.aone.module.salesThirdParty.model.SalesThirdParty;
import com.aone.module.salesThirdParty.service.ISalesThirdPartyService;

@Lazy
@Service("salesThirdPartyServiceImpl")
public class SalesThirdPartyServiceImpl extends AbstractBaseMasterService<SalesThirdParty  , Long, ISalesThirdPartyDao> implements
		ISalesThirdPartyService {
	
	private ISalesThirdPartyDao salesThirdPartyDao;

	@Override
	public ISalesThirdPartyDao getRepository() {
		return getSalesThirdPartyDao();
	}

	public ISalesThirdPartyDao getSalesThirdPartyDao() {
		return salesThirdPartyDao;
	}

	@Autowired
	@Qualifier(value = "salesThirdPartyDaoImpl")
	public void setSalesThirdPartyDao(ISalesThirdPartyDao salesThirdPartyDao) {
		this.salesThirdPartyDao = salesThirdPartyDao;
	}

	@Override
	public int deleteBySaleId(long saleId) {
		return getRepository().deleteBySaleId(saleId);
	}
	
	@Override
	public List<SalesThirdParty> getBySalesId(long salesId){
		Map<String, Object> params = new HashMap<>();
		params.put("salesId", salesId);
		params.put("deleted", false);
		return getRepository().getByQueryData(params, Collections.emptyMap());
	}
}