package com.aone.module.files.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aone.commons.utils.FileUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.files.constant.FilesDataModuleName;
import com.aone.module.files.dao.IFilesDataDao;
import com.aone.module.files.model.FilesData;
import com.aone.module.files.service.IFilesDataService;

@Lazy
@Service("filesDataServiceImpl")
public class FilesDataServiceImpl extends AbstractBaseMasterService<FilesData, Long, IFilesDataDao>
		implements IFilesDataService {

	private IFilesDataDao  filesDataDao;
	private ServletContext context;
	
	@Override
	public IFilesDataDao getRepository() {
		return getFilesDataDao();
	}

	public IFilesDataDao getFilesDataDao() {
		return filesDataDao;
	}

	@Autowired
	@Qualifier(value = "filesDataDaoImpl")
	public void setFilesDataDao(IFilesDataDao filesDataDao) {
		this.filesDataDao = filesDataDao;
	}
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Override
	public String getFullPath(FilesDataModuleName dataPathConstant) {
		return context.getRealPath(dataPathConstant.getPath());
	}
	
	@Override
	public String getBasePath() {
		return context.getRealPath(StringUtils.EMPTY);
	}
	
	@Override
	public List<FilesData> getFilesDataByContact(FilesData filesData){
		return getRepository().getFilesDataByModule(filesData);
	}

	@Override
	public ResultCodeConstant validateData(FilesData filesData) {
		if (filesData == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		if (filesData.getForeinKey() <= 0) {
			return ResultCodeConstant.FILES_DATA_FOREIGN_KEY_NOT_FOUND;
		}
		if (filesData.getModuleName() == null || filesData.getModuleName().isEmpty()) {
			return ResultCodeConstant.FILES_DATA_MOUDLE_NAME_NOT_FOUND;
		}
		
		FilesDataModuleName dataModuleName = FilesDataModuleName.getByValue(filesData.getModuleName());
		if(dataModuleName == null) {
			return ResultCodeConstant.FILES_DATA_MOUDLE_NAME_WRONG;
		}
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<FilesData>> saveWithFile(RequestData<FilesData, Long> requestData,
			MultipartFile[] uploadingFiles) throws IOException {
		
		FilesData filesData = requestData.getData();
		
		ResultCodeConstant resultCodeConstant = validateData(filesData);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<FilesData> responseData = new ResponseData<>(filesData, resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		
		// save files details
		FilesDataModuleName dataModuleName = FilesDataModuleName.getByValue(filesData.getModuleName());
		FilesData dataToSave = null;
		for(MultipartFile uploadedFile : uploadingFiles) {
			dataToSave = new FilesData();
			dataToSave.setForeinKey(filesData.getForeinKey());
			dataToSave.setModuleName(filesData.getModuleName());
			
			String baseFilePath = dataModuleName.getPath() + File.separator + FileUtils.getFileName(uploadedFile.getOriginalFilename());
			String filePath = getBasePath() + File.separator + baseFilePath;
			File file = new File(filePath);
			uploadedFile.transferTo(file);
			dataToSave.setImagePath(baseFilePath);
			this.save(dataToSave);
		}
		
		IResponseData<FilesData> responseData = new ResponseData<>(filesData, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<FilesData>> updateWithFile(RequestData<FilesData, Long> requestData,
			MultipartFile[] uploadingFiles) throws IOException {
		
		FilesData filesData = requestData.getData();
		
		ResultCodeConstant resultCodeConstant = validateData(filesData);
		if(ResultCodeConstant.SUCCESS != resultCodeConstant) {
			IResponseData<FilesData> responseData = new ResponseData<>(filesData, resultCodeConstant);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
		
		// save files details
		FilesDataModuleName dataModuleName = FilesDataModuleName.getByValue(filesData.getModuleName());
		
		FilesData dataToUpdate = null;
		for(MultipartFile uploadedFile : uploadingFiles) {
			dataToUpdate = new FilesData();
			dataToUpdate.setForeinKey(filesData.getForeinKey());
			dataToUpdate.setModuleName(filesData.getModuleName());
			
			String baseFilePath = dataModuleName.getPath() + File.separator + FileUtils.getFileName(uploadedFile.getOriginalFilename());
			String filePath = getBasePath() + File.separator + baseFilePath;
			File file = new File(filePath);
			uploadedFile.transferTo(file);
			dataToUpdate.setImagePath(baseFilePath);
			// update files details
			this.update(requestData);
		}
		IResponseData<FilesData> responseData = new ResponseData<>(filesData, resultCodeConstant);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<FilesData>> getFileData(RequestData<FilesData, Long> requestData) throws IOException {
		// save files details
		FilesData filesData = requestData.getData();
		return getFileData(filesData);
	}
	
	@Override
	public ResponseEntity<IResponseData<FilesData>> getFileData(FilesData filesData) throws IOException {
		// save files details
		Map<String, Object> params = new HashMap<>();
		params.put("foreinKey", filesData.getForeinKey());
		params.put("moduleName", filesData.getModuleName());
		params.put("deleted", false);
		
		// reponse of web service
		IResponseData<FilesData> responseData = new ResponseData<>(getRepository().getByQueryData(params, new HashMap<>()), ResultCodeConstant.SUCCESS);
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteFileData(FilesData filesData) throws IOException {
		// save files details
		Map<String, Object> params = new HashMap<>();
		params.put("foreinKey", filesData.getForeinKey());
		params.put("moduleName", filesData.getModuleName());
		
		// reponse of web service
		List<FilesData> filesDatas = getRepository().getByQueryData(params, new HashMap<>());
		String filePath;
		Path filePathObj; 
		for(FilesData data : filesDatas) {
			filePath = getBasePath() + data.getImagePath();
			filePathObj = Paths.get(filePath);
			Files.delete(filePathObj);
			filesDataDao.delete(data);
		}
		return true;
	}
}
