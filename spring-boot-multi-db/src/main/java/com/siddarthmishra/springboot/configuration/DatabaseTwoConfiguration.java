package com.siddarthmishra.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:/database/database-two.properties")
@EnableJpaRepositories(basePackages = "com.siddarthmishra.springboot.repository.db2", entityManagerFactoryRef = "db2EntityManagerFactory", transactionManagerRef = "db2TransactionManager")
public class DatabaseTwoConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.db2")
	DataSourceProperties db2DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	DataSource db2DataSource(@Qualifier("db2DataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("db2DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.siddarthmishra.springboot.entity.db2")
				.persistenceUnit("db2").build();
	}

	@Bean
	PlatformTransactionManager db2TransactionManager(
			@Qualifier("db2EntityManagerFactory") EntityManagerFactory localEntityManagerFactory) {
		return new JpaTransactionManager(localEntityManagerFactory);
	}
}
