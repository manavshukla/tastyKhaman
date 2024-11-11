package com.aone.config;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.aone.module.files.constant.FilesDataModuleName;

/**
 * The Class StartUpService.
 *
 * @author Bharat on Jun 24, 2017
 */
@Configuration
public class StartUpService implements InitializingBean {
	
	private static final Logger logger = Logger.getLogger(StartUpService.class);

	/** The context. */
	@Autowired
	private ServletContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		createFilePaths();
	}

	/**
	 * Creates the file paths.
	 */
	private void createFilePaths() {
		try {
			logger.info("Creating directory on startup service : ");
			for (FilesDataModuleName dataModuleName : FilesDataModuleName.values()) {
				String path = context.getRealPath(dataModuleName.getPath());
				File file = new File(path);
				if (!file.exists() && file.mkdirs()) {
					logger.info("Directory is created on path : " + path);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
