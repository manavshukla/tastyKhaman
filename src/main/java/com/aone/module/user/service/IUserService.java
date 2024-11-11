package com.aone.module.user.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.user.model.User;

public interface IUserService extends IBaseMasterService<User, Long> {

	public ResponseEntity<IResponseData<Boolean>> checkUserName(RequestData<User, Long> requestData);

	public User getByUserName(String userName);

}
