package com.aone.module.files.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.files.model.FilesData;

public interface IFilesDataController extends IBaseMasterController<FilesData, Long> {

	public ResponseEntity<IResponseData<FilesData>> saveWithFile(String bodyData, MultipartFile[] uploadingFiles) throws IOException;

	public ResponseEntity<IResponseData<FilesData>> updateWithFile(String bodyData, MultipartFile[] uploadingFiles) throws IOException;

	public ResponseEntity<IResponseData<FilesData>> getFilesData(RequestData<FilesData, Long> requestData) throws IOException;

}
