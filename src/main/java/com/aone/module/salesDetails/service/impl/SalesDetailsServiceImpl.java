package com.aone.module.salesDetails.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.item.model.Item;
import com.aone.module.item.service.IItemService;
import com.aone.module.salesDetails.dao.ISalesDetailsDao;
import com.aone.module.salesDetails.model.SalesDetails;
import com.aone.module.salesDetails.service.ISalesDetailsService;

@Lazy
@Service("salesDetailsServiceImpl")
public class SalesDetailsServiceImpl extends AbstractBaseMasterService<SalesDetails  , Long, ISalesDetailsDao> implements
		ISalesDetailsService {
	
	private ISalesDetailsDao salesDetailsDao;
	
	private IItemService itemService;

	@Override
	public ISalesDetailsDao getRepository() {
		return getSalesDetailsDao();
	}

	public ISalesDetailsDao getSalesDetailsDao() {
		return salesDetailsDao;
	}

	@Autowired
	@Qualifier(value = "salesDetailsDaoImpl")
	public void setSalesDetailsDao(ISalesDetailsDao salesDetailsDao) {
		this.salesDetailsDao = salesDetailsDao;
	}

	@Override
	public int deleteBySalesId(long salesId) {
		return getRepository().deleteBySalesId(salesId);
	}
	
	public IItemService getItemService() {
		return itemService;
	}

	@Autowired        
	@Qualifier(value="itemServiceImpl")
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public List<SalesDetails> getBySalesId(long salesId){
		Map<String, Object> params = new HashMap<>();
		params.put("salesId", salesId);
		params.put("deleted", false);
		List<SalesDetails> salesDetails = getRepository().getByQueryData(params, Collections.emptyMap());
		for(SalesDetails salesDetail: salesDetails) {
			Item item = new Item();
			item.setId(salesDetail.getItemId());
			item = itemService.getById(item);
			salesDetail.setItem(item);
		}
		return salesDetails;
	}
}