package com.aone.config.jsonformatting;

import java.io.IOException;
import java.time.LocalDateTime;

import com.aone.commons.ConfigConstant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		return LocalDateTime.parse(p.getValueAsString(), ConfigConstant.FORMATTER);
	}

}
