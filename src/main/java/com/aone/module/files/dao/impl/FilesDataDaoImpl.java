package com.aone.module.files.dao.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.files.dao.IFilesDataDao;
import com.aone.module.files.model.FilesData;

@Lazy
@Repository("filesDataDaoImpl")
public class FilesDataDaoImpl extends AbstractBaseMasterRepository<FilesData  , Long> implements IFilesDataDao   {

	@Override
	public Class<FilesData> getClazz() {
		return FilesData.class;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<FilesData> getFilesDataByModule(FilesData filesData) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("foreinKey", filesData.getForeinKey());
		params.put("deleted", false);
		params.put("moduleName", filesData.getModuleName());
		return super.getByQueryData(params, Collections.emptyMap());
	}

}
