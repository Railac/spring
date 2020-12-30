package com.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component //component, service, controller,repository --> 컴포넌트스캔에 읽힘, 빈 등록
public class TV {
	@Autowired 
	@Qualifier("appleSpeaker") //뭘가지고올지 직접 명시해준다.첫클자는 소문자, 클래스이름
	//@Resource(name="apple") -- Autowired + Qualifier 합친게 리소스
	Speaker speaker;
	public void volumeup() {
		speaker.volumup();
	}
	public TV() {
		System.out.println("TV 생성됨");
		
		
	}
	public void init() {
		System.out.println("init 객체 생성됨");
	}
	public void destroy() {
		System.out.println("destroy 객체 소멸");
	}
}
