package com.aone.module.item.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.item.constant.OrderTypeItemConstant;
import com.aone.module.item.model.Item;

public interface IItemService  extends IBaseMasterService<Item, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkItemCode(RequestData<Item,Long> requestData);

	public int updateItemStock(List<Item> itemList);

	public ResponseEntity<IResponseData<Item>> getItemListData(RequestData<SearchData<Item>, Long> requestData, OrderTypeItemConstant orderTypeItemConstant);

	public ResponseEntity<IResponseData<Item>> getLiveFoodListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getWholeSaleListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getDailyFoodCounterListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getRowMaterialListData(RequestData<SearchData<Item>, Long> requestData);

	
}
