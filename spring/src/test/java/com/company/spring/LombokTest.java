package com.company.spring;

import com.company.spring.controller.Member;

public class LombokTest {
	public static void main(String[] args) {
		Member member=Member.builder().id("id").pw("pw").build(); //초기화
	}
}
