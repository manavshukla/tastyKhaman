package com.aone.module.itemSize.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.itemSize.model.ItemSize;

public interface IItemSizeService extends IBaseMasterService<ItemSize, Long> {

	ResponseEntity<IResponseData<Boolean>> checkItemSizeName(RequestData<ItemSize, Long> requestData);
}
