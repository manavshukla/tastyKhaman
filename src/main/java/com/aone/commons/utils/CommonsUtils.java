package com.aone.commons.utils;


import java.time.LocalDateTime;

import com.aone.config.jsonformatting.LocalDateDeserializer;
import com.aone.config.jsonformatting.LocalDateSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


public class CommonsUtils {
	
	public static ObjectMapper getObjectMapperInstance() {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(LocalDateTime.class, new LocalDateSerializer());
		simpleModule.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
		mapper.registerModule(simpleModule);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}
