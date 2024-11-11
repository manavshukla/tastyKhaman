package com.aone.module.category.service.impl;

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
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.category.dao.ICategoryDao;
import com.aone.module.category.model.Category;
import com.aone.module.category.service.ICategoryService;

@Lazy
@Service("categoryServiceImpl")
public class CategoryServiceImpl extends AbstractBaseMasterService<Category, Long, ICategoryDao>
		implements ICategoryService {

	private ICategoryDao categoryDao;

	@Override
	public ICategoryDao getRepository() {
		return getCategoryDao();
	}

	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Autowired
	@Qualifier(value = "categoryDaoImpl")
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkCategoryName(RequestData<Category, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(Category category) {
		if(category == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(category.getName() == null || category.getName().isEmpty()) {
			return ResultCodeConstant.ITEM_CATEGORY_NAME_NOT_FOUND;
		}
		// check if category name already exist
		if(!getRepository().checkUniqueDataByField("name", category.getName(), "id", category.getId()).isEmpty()) {
			return ResultCodeConstant.ITEM_CATEGORY_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

}
