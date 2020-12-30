package com.company.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.company.test"})
public class IOCConfiguration {
	/*
	 * @Bean(initMethod ="init",destroyMethod = "destroy")
	 * 
	 * @Scope("prototype") public TV tv() { //<bean id="메소드명" class="" return new
	 * TV(); }
	 */
	
}
