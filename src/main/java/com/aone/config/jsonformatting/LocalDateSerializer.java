package com.aone.config.jsonformatting;

import java.io.IOException;
import java.time.LocalDateTime;

import com.aone.commons.ConfigConstant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(ConfigConstant.FORMATTER));
    }
}