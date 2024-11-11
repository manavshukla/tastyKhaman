package com.aone.module.category.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.category.controller.ICategoryController;
import com.aone.module.category.model.Category;
import com.aone.module.category.service.ICategoryService;

@RestController
@RequestMapping("/rest/category")
@SecurityClassRole(baseRoleName = SecurityRoleModule.ITEM_CATEGORY)
public class CategoryRestController extends AbstractBaseMasterRestController<Category, Long, ICategoryService> implements ICategoryController {

	private ICategoryService categoryService;
	
	@Override
	public ICategoryService getService() {
		return getCategoryService();
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	@Autowired
	@Qualifier(value="categoryServiceImpl")
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	@RequestMapping(value="/checkCategoryName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkCategoryName(@RequestBody RequestData<Category,Long> requestData) {
		return getService().checkCategoryName(requestData);
	}
	
}
