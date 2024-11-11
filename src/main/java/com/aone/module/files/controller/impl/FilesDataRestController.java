package com.aone.module.files.controller.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.files.controller.IFilesDataController;
import com.aone.module.files.model.FilesData;
import com.aone.module.files.service.IFilesDataService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest/filesData")
public class FilesDataRestController extends AbstractBaseMasterRestController<FilesData , Long, IFilesDataService > implements IFilesDataController  {

	private IFilesDataService filesDataService;
	
	@Override
	public IFilesDataService getService() {
		return getFilesDataService();
	}

	public IFilesDataService getFilesDataService() {
		return filesDataService;
	}

	@Autowired
	@Qualifier(value="filesDataServiceImpl")
	public void setFilesDataService(IFilesDataService filesDataService) {
		this.filesDataService = filesDataService;
	}

	@Override
	@RequestMapping(value="/saveWithFile", headers=("content-type=multipart/*"), method=RequestMethod.POST, consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<IResponseData<FilesData>> saveWithFile(@RequestParam("bodyData") String bodyData,@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RequestData<FilesData, Long> requestData = mapper.readValue(bodyData, new TypeReference<RequestData<FilesData, Long>>() {});
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return filesDataService.saveWithFile(requestData, uploadingFiles);
	}
	
	@Override
	@RequestMapping(value="/updateWithFile", headers=("content-type=multipart/*"), method=RequestMethod.POST, consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<IResponseData<FilesData>> updateWithFile(@RequestParam("bodyData") String bodyData,@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RequestData<FilesData, Long> requestData = mapper.readValue(bodyData, new TypeReference<RequestData<FilesData, Long>>() {});
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return filesDataService.updateWithFile(requestData, uploadingFiles);
	}
	
	@Override
	@RequestMapping(value="/getFilesData", method=RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<FilesData>> getFilesData(@RequestBody RequestData<FilesData,Long> requestData) throws IOException {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return filesDataService.getFileData(requestData.getData());
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String bodyData = "{\"data\": {\"foreinKey\":1,\"moduleName\":\"LIC_POLICY\"},\"requestToken\": \"1242354\",\"authToken\":\"1\"}";
		RequestData<FilesData, Long> requestData = mapper.readValue(bodyData, new TypeReference<RequestData<FilesData, Long>>() {});
		System.out.println(requestData);
	}
}
