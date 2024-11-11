package com.aone.module.files.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.files.constant.FilesDataModuleName;
import com.aone.module.files.model.FilesData;

public interface IFilesDataService extends IBaseMasterService<FilesData, Long> {

	public List<FilesData> getFilesDataByContact(FilesData filesData);

	public String getFullPath(FilesDataModuleName dataPathConstant);

	public String getBasePath();

	public ResponseEntity<IResponseData<FilesData>> saveWithFile(RequestData<FilesData, Long> requestData, MultipartFile[] uploadingFiles) throws IOException;

	public ResponseEntity<IResponseData<FilesData>> updateWithFile(RequestData<FilesData, Long> requestData, MultipartFile[] uploadingFiles) throws IOException;

	public ResponseEntity<IResponseData<FilesData>> getFileData(RequestData<FilesData, Long> requestData) throws IOException;

	public ResponseEntity<IResponseData<FilesData>> getFileData(FilesData filesData) throws IOException;

	public boolean deleteFileData(FilesData filesData) throws IOException;

}
