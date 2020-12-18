package com.company.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.spring.config.MvcConfiguration;
import com.company.spring.controller.Greeter;

public class Main {
	public static void main(String[] args) {
//		Greeter g = new Greeter();
//		g.setFormat("%s, 안녕하세요");
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(MvcConfiguration.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
