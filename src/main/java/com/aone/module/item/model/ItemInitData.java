package com.aone.module.item.model;

import java.util.List;

import com.aone.module.itemCategory.model.ItemCategory;

public class ItemInitData {
	List<ItemCategory> itemCategoryList;

	public List<ItemCategory> getItemCategoryList() {
		return itemCategoryList;
	}

	public void setItemCategoryList(List<ItemCategory> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}

	@Override
	public String toString() {
		return "itemInitData [itemCategoryList=" + itemCategoryList + "]";
	}
}
