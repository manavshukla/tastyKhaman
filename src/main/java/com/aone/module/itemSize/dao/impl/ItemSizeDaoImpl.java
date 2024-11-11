package com.aone.module.itemSize.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.itemSize.dao.IItemSizeDao;
import com.aone.module.itemSize.model.ItemSize;

@Lazy
@Repository("itemSizeDaoImpl")
public class ItemSizeDaoImpl extends AbstractBaseMasterRepository<ItemSize, Long> implements IItemSizeDao {

	@Override
	public Class<ItemSize> getClazz() {
		return ItemSize.class;
	}

}
