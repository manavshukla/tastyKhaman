package com.aone.module.category.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.category.dao.ICategoryDao;
import com.aone.module.category.model.Category;

@Lazy
@Repository("categoryDaoImpl")
public class CategoryDaoImpl extends AbstractBaseMasterRepository<Category, Long> implements ICategoryDao {

	@Override
	public Class<Category> getClazz() {
		return Category.class;
	}

}
