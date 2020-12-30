package com.company.test.config;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker{

	@Override
	public void volumup() {
		System.out.println("SonySpeaker");
	}

}
