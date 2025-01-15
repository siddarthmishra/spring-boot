package com.siddarthmishra.springboot.api.json.serializer;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.siddarthmishra.springboot.api.constants.CommonConstants;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	private static LocalDateSerializer uniqueInstance;

	public static LocalDateSerializer getInstance() {
		if (uniqueInstance == null) {
			synchronized (LocalDateSerializer.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new LocalDateSerializer();
				}
			}
		}
		return uniqueInstance;
	}

	private LocalDateSerializer() {
		// default private constructor
	}

	@Override
	public void serialize(LocalDate localDate, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(localDate.format(CommonConstants.FORMATTER_DD_MMM_YYYY));
	}
}
