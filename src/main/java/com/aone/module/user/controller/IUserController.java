package com.aone.module.user.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.user.model.User;

public interface IUserController extends IBaseMasterController<User, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkUserName(RequestData<User,Long> requestData);
}
