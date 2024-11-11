package com.aone.module.item.dao;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.item.model.Item;

public interface IItemDao extends IBaseMasterRepository<Item, Long>{

	public int updateItemStock(Item item);
	
}
