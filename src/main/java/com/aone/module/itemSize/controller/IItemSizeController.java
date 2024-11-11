package com.aone.module.itemSize.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.itemSize.model.ItemSize;

public interface IItemSizeController extends IBaseMasterController<ItemSize, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkItemSizeName(@RequestBody RequestData<ItemSize,Long> requestData);
}
