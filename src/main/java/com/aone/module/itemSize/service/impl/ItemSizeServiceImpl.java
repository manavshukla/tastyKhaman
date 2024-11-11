package com.aone.module.itemSize.service.impl;

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
import com.aone.module.itemSize.dao.IItemSizeDao;
import com.aone.module.itemSize.model.ItemSize;
import com.aone.module.itemSize.service.IItemSizeService;

@Lazy
@Service("itemSizeServiceImpl")
public class ItemSizeServiceImpl extends AbstractBaseMasterService<ItemSize, Long, IItemSizeDao>
		implements IItemSizeService {

	private IItemSizeDao itemSizeDao;

	@Override
	public IItemSizeDao getRepository() {
		return getItemSizeDao();
	}

	public IItemSizeDao getItemSizeDao() {
		return itemSizeDao;
	}

	@Autowired
	@Qualifier(value = "itemSizeDaoImpl")
	public void setItemSizeDao(IItemSizeDao itemSizeDao) {
		this.itemSizeDao = itemSizeDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkItemSizeName(RequestData<ItemSize, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(ItemSize itemSize) {
		if(itemSize == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(itemSize.getName() == null || itemSize.getName().isEmpty()) {
			return ResultCodeConstant.ITEM_ITEMSIZE_NAME_NOT_FOUND;
		}
		// check if Company name already exist
		if(!getRepository().checkUniqueDataByField("name", itemSize.getName(), "id", itemSize.getId()).isEmpty()) {
			return ResultCodeConstant.ITEM_ITEMSIZE_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

}
