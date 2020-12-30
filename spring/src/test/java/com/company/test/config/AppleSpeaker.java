package com.company.test.config;

import org.springframework.stereotype.Component;

@Component //("불려갈 이름값설정")
public class AppleSpeaker implements Speaker{

	@Override
	public void volumup() {
		System.out.println("AppleSpeaker");
	}

}
