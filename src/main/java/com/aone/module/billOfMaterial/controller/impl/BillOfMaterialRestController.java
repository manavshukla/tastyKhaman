package com.aone.module.billOfMaterial.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.billOfMaterial.controller.IBillOfMaterialController;
import com.aone.module.billOfMaterial.model.BillOfMaterial;
import com.aone.module.billOfMaterial.service.IBillOfMaterialService;

@RestController
@RequestMapping("/rest/billOfMaterial")
public class BillOfMaterialRestController extends AbstractBaseMasterRestController<BillOfMaterial  , Long, IBillOfMaterialService > implements IBillOfMaterialController  {

	private IBillOfMaterialService billOfMaterialService;
	
	@Override
	public IBillOfMaterialService getService() {
		return getBillOfMaterialService();
	}

	public IBillOfMaterialService getBillOfMaterialService() {
		return billOfMaterialService;
	}

	@Autowired
	@Qualifier(value="billOfMaterialServiceImpl")
	public void setBillOfMaterialService(IBillOfMaterialService billOfMaterialService) {
		this.billOfMaterialService = billOfMaterialService;
	}

}
