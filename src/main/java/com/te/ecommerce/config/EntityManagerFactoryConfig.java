package com.te.ecommerce.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEMFO() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("springdb");
		return factoryBean;
	}

}