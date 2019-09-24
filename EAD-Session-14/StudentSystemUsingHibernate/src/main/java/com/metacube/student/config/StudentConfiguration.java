package com.metacube.student.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class StudentConfiguration {

	@Autowired
	/**
	 * @return JpaTransactionManager
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setDataSource(getDataSource());
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	/**
	 * @return EntityManagerFactory
	 */
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(hibernateProperties());
		factory.setPackagesToScan("com.metacube.student.model");
		factory.setDataSource(getDataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	/**
	 * @return DataSource
	 */
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/student", "root", "1234");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}

	@Bean
	/**
	 * @return Properties
	 */
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
}
