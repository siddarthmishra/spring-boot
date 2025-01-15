package com.siddarthmishra.springboot.api.json.deserializer;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.siddarthmishra.springboot.api.constants.CommonConstants;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	private static LocalDateDeserializer uniqueInstance;

	public static LocalDateDeserializer getInstance() {
		if (uniqueInstance == null) {
			synchronized (LocalDateDeserializer.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new LocalDateDeserializer();
				}
			}
		}
		return uniqueInstance;
	}

	private LocalDateDeserializer() {
		// default private constructor
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		return LocalDate.parse(p.getValueAsString(), CommonConstants.FORMATTER_DD_MMM_YYYY);
	}
}
