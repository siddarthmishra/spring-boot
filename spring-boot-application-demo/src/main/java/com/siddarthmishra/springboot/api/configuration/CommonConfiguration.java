package com.siddarthmishra.springboot.api.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.siddarthmishra.springboot.api.json.deserializer.LocalDateDeserializer;
import com.siddarthmishra.springboot.api.json.deserializer.LocalDateTimeDeserializer;
import com.siddarthmishra.springboot.api.json.serializer.LocalDateSerializer;
import com.siddarthmishra.springboot.api.json.serializer.LocalDateTimeSerializer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class CommonConfiguration {

	// @Bean
	// commented @Bean so that these can be loaded from the application.properties
	HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(System.getenv("JDBC_URL"));
		config.setUsername(System.getenv("DB_USER"));
		config.setPassword(System.getenv("DB_PASSWORD"));
		config.setMinimumIdle(4);
		config.setMaximumPoolSize(4);
		config.addDataSourceProperty("oracle.jdbc.defaultConnectionValidation", "LOCAL");
		return new HikariDataSource(config);
	}

	/**
	 * Common configuration for JSON ObjectMapper. It can also be done at each
	 * entity level using annotations.
	 */
	@Bean(name = "objectMapper")
	ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDate.class, LocalDateSerializer.getInstance());
		javaTimeModule.addDeserializer(LocalDate.class, LocalDateDeserializer.getInstance());
		javaTimeModule.addSerializer(LocalDateTime.class, LocalDateTimeSerializer.getInstance());
		javaTimeModule.addDeserializer(LocalDateTime.class, LocalDateTimeDeserializer.getInstance());
		objectMapper.registerModule(javaTimeModule);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		return objectMapper;
	}

}
