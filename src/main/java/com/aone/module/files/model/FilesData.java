package com.aone.module.files.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.files.constant.FilesDataDbColPojoConstant;

@Entity
@Table(name = "files_data")
public class FilesData extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = FilesDataDbColPojoConstant.IMAGE_PATH)
	private String imagePath;

	@Column(name = FilesDataDbColPojoConstant.FOREIGN_KEY)
	private long foreinKey;

	@Column(name = FilesDataDbColPojoConstant.MODULE_NAME)
	private String moduleName;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public long getForeinKey() {
		return foreinKey;
	}

	public void setForeinKey(long foreinKey) {
		this.foreinKey = foreinKey;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "Files [imagePath=" + imagePath + ", foreinKey=" + foreinKey + ", moduleName=" + moduleName + "]";
	}
	
}
