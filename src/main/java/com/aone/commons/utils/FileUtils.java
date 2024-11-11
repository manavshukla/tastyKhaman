package com.aone.commons.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * The Class FileUtils.
 *
 * @author bharat on Jul 24, 2017 1:02:41 AM
 */
@Component
public class FileUtils {

	/** The Constant dateFormat. */
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");

	/**
	 * Upload file.
	 *
	 * @param file the file
	 * @param filePath the file path
	 */
	public static void uploadFile(MultipartFile file, String filePath) {
		byte[] bytes;
		BufferedOutputStream stream;
		try {
			bytes = file.getBytes();
			stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the file name.
	 *
	 * @param fileName
	 *            the file name
	 * @return the file name
	 */
	public static String getFileName(String fileName) {
		Date date = new Date();
		try {
			return dateFormat.format(date) + "_" + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormat.format(date) + "_";
	}

}
