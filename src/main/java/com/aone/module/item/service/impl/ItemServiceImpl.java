package com.aone.module.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.item.constant.OrderTypeItemConstant;
import com.aone.module.item.dao.IItemDao;
import com.aone.module.item.model.Item;
import com.aone.module.item.model.ItemInitData;
import com.aone.module.item.service.IItemService;
import com.aone.module.itemCategory.model.ItemCategory;
import com.aone.module.itemCategory.service.IItemCategoryService;

@Lazy
@Service("itemServiceImpl")
public class ItemServiceImpl extends AbstractBaseMasterService<Item, Long, IItemDao> implements IItemService {

	private IItemDao itemDao;

	@Override
	public IItemDao getRepository() {
		return getItemDao();
	}

	public IItemDao getItemDao() {
		return itemDao;
	}

	@Autowired
	@Qualifier(value = "itemDaoImpl")
	public void setItemDao(IItemDao itemDao) {
		this.itemDao = itemDao;
	}

	private IItemCategoryService itemCategoryService;

	public IItemCategoryService getItemCategoryService() {
		return itemCategoryService;
	}

	@Autowired
	@Qualifier(value = "itemCategoryServiceImpl")
	public void setItemCategoryService(IItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}

	@Override
	public int updateItemStock(List<Item> itemList) {
		int count = 0;
		for (Item item : itemList) {
			if (getRepository().updateItemStock(item) > 0) {
				count++;
			}
		}
		return count;
	}

	@Override
	public ResultCodeConstant validateData(Item item) {
		if (item == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		// validate name

		// check if category name already exist

		if (item.getCategoryId() <= 0) {
			return ResultCodeConstant.ITEM_CATEGORY_REQURIED;
		}

		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResponseEntity<IResponseData<Boolean>> checkItemCode(RequestData<Item, Long> requestData) {
		return null;
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getLiveFoodListData(RequestData<SearchData<Item>, Long> requestData) {
		return this.getItemListData(requestData, OrderTypeItemConstant.LIVE_FOOD);
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getWholeSaleListData(RequestData<SearchData<Item>, Long> requestData) {
		return this.getItemListData(requestData, OrderTypeItemConstant.WHOLE_SALE);
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getDailyFoodCounterListData(
			RequestData<SearchData<Item>, Long> requestData) {
		return this.getItemListData(requestData, OrderTypeItemConstant.DAILY_FOOD_COUNTER);
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getRowMaterialListData(RequestData<SearchData<Item>, Long> requestData) {
		return this.getItemListData(requestData, OrderTypeItemConstant.ROW_MATERIAL);
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getItemListData(RequestData<SearchData<Item>, Long> requestData,
			OrderTypeItemConstant orderTypeItemConstant) {

		List<Item> itemList = itemDao.getByFieldName("orderType", orderTypeItemConstant.getValue());

		IResponseData<Item> responseData = new ResponseData<>(itemList, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IResponseData<Item>> getById(RequestData<Item, Long> requestData) {
		ResponseEntity<IResponseData<Item>> responseEntity = super.getById(requestData);
		IResponseData<Item> responseData = responseEntity.getBody();
		
		if(responseData.getResponseCode() != ResultCodeConstant.SUCCESS.getResultCode()) {
			return responseEntity;
		}
		
		Item item = responseData.getData();
		
		// fecth country list
		SearchData<ItemCategory> searchData = new SearchData<>();
		List<ItemCategory> itemCategoryList = itemCategoryService.getActiveData(searchData);
		
		ItemInitData itemInitData = new ItemInitData();
		itemInitData.setItemCategoryList(itemCategoryList);

		item.setItemInitData(itemInitData);
		return responseEntity;
	}
	
	
	@Override
	public ResponseEntity<IResponseData<Item>> getActiveData(RequestData<SearchData<Item>, Long> requestData) {
		ResponseEntity<IResponseData<Item>> responseEntity = super.getActiveData(requestData);
		
		IResponseData<Item> responseData = responseEntity.getBody();
		
		if(responseData.getResponseCode() != ResultCodeConstant.SUCCESS.getResultCode()) {
			return responseEntity;
		}
				
		List<Item> itemList = responseEntity.getBody().getDataList();
		ItemCategory itemCategory = new ItemCategory();
		for(Item item : itemList) {
			itemCategory.setId(item.getCategoryId());
			item.setItemCategory(itemCategoryService.getById(itemCategory));
		}
		
		return responseEntity;
	}

}