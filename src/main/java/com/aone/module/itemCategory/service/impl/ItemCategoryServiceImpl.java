package com.aone.module.itemCategory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.itemCategory.dao.IItemCategoryDao;
import com.aone.module.itemCategory.model.ItemCategory;
import com.aone.module.itemCategory.service.IItemCategoryService;

@Lazy
@Service("itemCategoryServiceImpl")
public class ItemCategoryServiceImpl extends AbstractBaseMasterService<ItemCategory, Long, IItemCategoryDao> implements
		IItemCategoryService {
	
	private IItemCategoryDao itemCategoryDao;

	@Override
	public IItemCategoryDao getRepository() {
		return getItemCategoryDao();
	}
	
	public IItemCategoryDao getItemCategoryDao() {
		return itemCategoryDao;
	}
	
	@Autowired
	@Qualifier(value = "itemCategoryDaoImpl")
	public void setItemCategoryDao(IItemCategoryDao itemCategoryDao) {
		this.itemCategoryDao = itemCategoryDao;
	}
}
