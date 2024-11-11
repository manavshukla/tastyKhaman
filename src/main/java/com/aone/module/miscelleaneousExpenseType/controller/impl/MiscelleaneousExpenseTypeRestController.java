package com.aone.module.miscelleaneousExpenseType.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.miscelleaneousExpenseType.controller.IMiscelleaneousExpenseTypeController;
import com.aone.module.miscelleaneousExpenseType.model.MiscelleaneousExpenseType;
import com.aone.module.miscelleaneousExpenseType.service.IMiscelleaneousExpenseTypeService;

@RestController
@RequestMapping("/rest/miscelleaneousExpenseType")
public class MiscelleaneousExpenseTypeRestController extends AbstractBaseMasterRestController<MiscelleaneousExpenseType, Long, IMiscelleaneousExpenseTypeService> implements IMiscelleaneousExpenseTypeController {
	
	private IMiscelleaneousExpenseTypeService miscelleaneousExpenseTypeService;
	
	@Override
	public IMiscelleaneousExpenseTypeService getService() {
		return getMiscelleaneousExpenseTypeService();
	}

	public IMiscelleaneousExpenseTypeService getMiscelleaneousExpenseTypeService() {
		return miscelleaneousExpenseTypeService;
	}

	@Autowired        
	@Qualifier(value="miscelleaneousExpenseTypeServiceImpl")
	public void setMiscelleaneousExpenseTypeService(
			IMiscelleaneousExpenseTypeService miscelleaneousExpenseTypeService) {
		this.miscelleaneousExpenseTypeService = miscelleaneousExpenseTypeService;
	}
}
