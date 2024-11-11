package com.aone.module.itemSize.controller.impl;

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
import com.aone.module.itemSize.controller.IItemSizeController;
import com.aone.module.itemSize.model.ItemSize;
import com.aone.module.itemSize.service.IItemSizeService;

@RestController
@RequestMapping("/rest/itemsize")
@SecurityClassRole(baseRoleName = SecurityRoleModule.ITEMSIZE)
public class ItemSizeRestController extends AbstractBaseMasterRestController <ItemSize, Long, IItemSizeService> implements IItemSizeController {

	private IItemSizeService itemSizeService;
	
	@Override
	public IItemSizeService getService() {
		return getItemSizeService();
	}

	public IItemSizeService getItemSizeService() {
		return itemSizeService;
	}

	@Autowired
	@Qualifier(value="itemSizeServiceImpl")
	public void setItemSizeService(IItemSizeService itemSizeService) {
		this.itemSizeService = itemSizeService;
	}
	
	@Override
	@RequestMapping(value="/checkItemSizeName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkItemSizeName(@RequestBody RequestData<ItemSize,Long> requestData) {
		return getService().checkItemSizeName(requestData);
	}
	
}
