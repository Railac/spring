package com.company.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

// @Configuration
public class MvcConfiguration implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	@Bean
	public ViewResolver beanNameResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(1);
		return resolver;
	}
	
//	@Bean//컨테이너 객체를 등록
//	public Greeter greeter() {
//		Greeter g = new Greeter();
//		g.setFormat("%s, 안녕하세요");
//		return g;
//	}
	
	
}
