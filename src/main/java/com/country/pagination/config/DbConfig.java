package com.country.pagination.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	// Database Configurations

	@Value("${db.driverClass}")
	private String dbdriverClass;

	@Value("${db.maxActive}")
	private int dbmaxActive;

	@Value("${db.maxIdle}")
	private int dbmaxIdle;

	@Value("${db.minIdle}")
	private int dbminIdle;

	@Value("${db.maxwait}")
	private int dbmaxwait;

	@Value("${db.removeAbandonedTimeout}")
	private int dbremoveAbandonedTimeout;

	@Value("${db.initialSize}")
	private int dbinitialSize;

	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;
	
	@Value("${db.validationQuery}")
	private String validationQuery;

	@Bean
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(dbdriverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(dbremoveAbandonedTimeout);
		dataSource.setInitialSize(dbinitialSize);
		dataSource.setMaxActive(dbmaxActive);
		dataSource.setMinIdle(dbminIdle);
		dataSource.setMaxWait(dbmaxwait);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery(validationQuery);
		return dataSource;
	}

}
