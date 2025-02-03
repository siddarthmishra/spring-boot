package com.siddarthmishra.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:/database/database-one.properties")
@EnableJpaRepositories(basePackages = "com.siddarthmishra.springboot.repository.db1", entityManagerFactoryRef = "db1EntityManagerFactory", transactionManagerRef = "db1TransactionManager")
public class DatabaseOneConfiguration {

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	DataSourceProperties db1DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	DataSource db1DataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean
	LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("db1DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.siddarthmishra.springboot.entity.db1")
				.persistenceUnit("db1").build();
	}

	@Bean
	PlatformTransactionManager db1TransactionManager(
			@Qualifier("db1EntityManagerFactory") EntityManagerFactory localEntityManagerFactory) {
		return new JpaTransactionManager(localEntityManagerFactory);
	}
}
