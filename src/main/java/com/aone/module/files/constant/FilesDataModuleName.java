package com.aone.module.files.constant;

import java.util.HashMap;
import java.util.Map;

public enum FilesDataModuleName {
	
	USER_PROFILE("USER_PROFILE", "/resources/images/uploaded/user-profile-images"),
	SALES_JOBCARD("SALES_JOBCARD","/resources/images/uploaded/sales-jobcard-images"),
	REPORTS("REPORTS","/resources/reports")
	;
	
	private String value;
	private String path;
	
	private static Map<String, FilesDataModuleName> moduleWiseFilesDataConst = new HashMap<>();
	
	static {
		for(FilesDataModuleName dataModuleName : values()) {
			moduleWiseFilesDataConst.put(dataModuleName.getValue(), dataModuleName);
		}
	}

	private FilesDataModuleName(String value, String path) {
		this.value = value;
		this.path = path;
	}

	public String getValue() {
		return value;
	}
	
	public String getPath() {
		return path;
	}
	
	public static FilesDataModuleName getByValue(String value) {
		return moduleWiseFilesDataConst.get(value);
	}

}
