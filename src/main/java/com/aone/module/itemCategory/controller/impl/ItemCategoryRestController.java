package com.aone.module.itemCategory.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.itemCategory.controller.IItemCategoryController;
import com.aone.module.itemCategory.model.ItemCategory;
import com.aone.module.itemCategory.service.IItemCategoryService;

@RestController
@RequestMapping("/rest/itemCategory")
@SecurityClassRole(baseRoleName = SecurityRoleModule.ITEM_CATEGORY)
public class ItemCategoryRestController extends AbstractBaseMasterRestController<ItemCategory, Long, IItemCategoryService> implements IItemCategoryController {
	
	private IItemCategoryService itemCategoryService;
	
	@Override
	public IItemCategoryService getService() {
		return getItemCategoryService();
	}

	public IItemCategoryService getItemCategoryService() {
		return itemCategoryService;
	}

	@Autowired        
	@Qualifier(value="itemCategoryServiceImpl")
	public void setItemCategoryService(IItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<ItemCategory>> getActiveData(@RequestBody RequestData<SearchData<ItemCategory>, Long> requestData) {
		return super.getActiveData(requestData);
	}
	
}
