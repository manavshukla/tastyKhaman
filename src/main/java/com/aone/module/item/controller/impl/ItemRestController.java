package com.aone.module.item.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.item.controller.IItemController;
import com.aone.module.item.model.Item;
import com.aone.module.item.service.IItemService;

@RestController
@RequestMapping("/rest/item")
@SecurityClassRole(baseRoleName = SecurityRoleModule.ITEM)
public class ItemRestController extends AbstractBaseMasterRestController<Item, Long, IItemService> implements IItemController {
	
	private IItemService itemService;
	
	@Override
	public IItemService getService() {
		return getItemService();
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
	public ResponseEntity<IResponseData<Boolean>> checkItemShortName(RequestData<Item, Long> requestData) {
		return null;
	}
	
	@Override
	@RequestMapping(value="/getLiveFoodListData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Item>> getLiveFoodListData(@RequestBody RequestData<SearchData<Item>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getLiveFoodListData(requestData);
	}
	
	@Override
	@RequestMapping(value="/getWholeSaleListData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Item>> getWholeSaleListData(@RequestBody RequestData<SearchData<Item>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getWholeSaleListData(requestData);
	}
	
	@Override
	@RequestMapping(value="/getDailyFoodCounterListData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Item>> getDailyFoodCounterListData(@RequestBody RequestData<SearchData<Item>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getDailyFoodCounterListData(requestData);
	}
	
	@Override
	@RequestMapping(value="/getRowMaterialListData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Item>> getRowMaterialListData(@RequestBody RequestData<SearchData<Item>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getRowMaterialListData(requestData);
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<Item>> getActiveData(@RequestBody RequestData<SearchData<Item>, Long> requestData) {
		return super.getActiveData(requestData);
	}
	
}
