package com.siddarthmishra.springboot.api.json.deserializer;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.siddarthmishra.springboot.api.constants.CommonConstants;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	private static LocalDateTimeDeserializer uniqueInstance;

	public static LocalDateTimeDeserializer getInstance() {
		if (uniqueInstance == null) {
			synchronized (LocalDateTimeDeserializer.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new LocalDateTimeDeserializer();
				}
			}
		}

		return uniqueInstance;
	}

	private LocalDateTimeDeserializer() {
		// default private constructor
	}

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		return LocalDateTime.parse(p.getValueAsString(), CommonConstants.FORMATTER_DD_MMM_YYYY_HH_MM_SS_SSS);
	}
}
