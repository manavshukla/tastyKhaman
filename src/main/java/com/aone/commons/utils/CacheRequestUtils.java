package com.aone.commons.utils;

import java.util.HashMap;
import java.util.Map;

import com.aone.corelibrary.model.impl.RequestData;

public class CacheRequestUtils {
	
	private static Map<String, RequestData> requestChachedData = new HashMap<>();
			
	public static boolean chacheRequestData(String key, RequestData value) {
		requestChachedData.put(key, value);
		return true;
	}

	public static RequestData getRequestData(String key) {
		return requestChachedData.get(key);
	}
	
	public static RequestData deleteRequestData(String key) {
		return requestChachedData.remove(key);
	}
	
	public static String generateKey() {
		return "AONE--" + System.currentTimeMillis() + "--THREAD";
	}
}
