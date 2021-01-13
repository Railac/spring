package com.company.spring.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	
	@Scheduled(fixedRate=5000)
	public void doSomething() {
	    // something that should run periodically
		System.out.println("5초마다 호출이됩니다.");
	}
}
