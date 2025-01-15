package com.siddarthmishra.springboot.api.json.serializer;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.siddarthmishra.springboot.api.constants.CommonConstants;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	private static LocalDateTimeSerializer uniqueInstance;

	public static LocalDateTimeSerializer getInstance() {
		if (uniqueInstance == null) {
			synchronized (LocalDateTimeSerializer.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new LocalDateTimeSerializer();
				}
			}
		}
		return uniqueInstance;
	}

	private LocalDateTimeSerializer() {
		// default private constructor
	}

	@Override
	public void serialize(LocalDateTime localDateTime, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {
		gen.writeString(localDateTime.format(CommonConstants.FORMATTER_DD_MMM_YYYY_HH_MM_SS_SSS));
	}

}
