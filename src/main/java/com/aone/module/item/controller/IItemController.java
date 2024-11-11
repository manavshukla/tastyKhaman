package com.aone.module.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.item.model.Item;

public interface IItemController extends IBaseMasterController<Item, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkItemShortName(@RequestBody RequestData<Item, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getLiveFoodListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getWholeSaleListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getDailyFoodCounterListData(RequestData<SearchData<Item>, Long> requestData);

	public ResponseEntity<IResponseData<Item>> getRowMaterialListData(RequestData<SearchData<Item>, Long> requestData);
}
