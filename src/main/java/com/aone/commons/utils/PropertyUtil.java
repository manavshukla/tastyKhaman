package com.aone.commons.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.aone.commons.PropertyFileConstant;

/**
 * The Class PropertyUtil.
 *
 * @author Bharat on Jul 8, 2017
 */
public class PropertyUtil {
	
	/** The Constant props. */
	private static final Properties props = new Properties();

	static {
		try {
			InputStream is = null;
			// Get properties object
			is = PropertyUtil.class.getResourceAsStream("/prop/config.properties");
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the property object.
	 *
	 * @return the property object
	 */
	public static Properties getPropertyObject() {
		InputStream is = null;
		final Properties props;
		try {
			props = new Properties();
			// Get properties object
			is = PropertyUtil.class.getResourceAsStream("/config.properties");
			props.load(is);
			return props;
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the value.
	 *
	 * @param propertyFileConstant the property file constant
	 * @return the value
	 */
	public static String getValue(PropertyFileConstant propertyFileConstant) {
		try {
			return props.getProperty(propertyFileConstant.getValue(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean checkProdEnv() {
		try {
			String value = props.getProperty(PropertyFileConstant.ENV_PROD.getValue(), null);
			return value == null ? false : Boolean.parseBoolean(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
