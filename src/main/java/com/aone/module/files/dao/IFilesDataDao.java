package com.aone.module.files.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.files.model.FilesData;

public interface IFilesDataDao extends IBaseMasterRepository<FilesData , Long>{

	public List<FilesData> getFilesDataByModule(FilesData filesData);

}
