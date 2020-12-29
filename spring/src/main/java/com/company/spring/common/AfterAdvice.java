package com.company.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //<bean>등록
@Aspect //<aop:aspect>
public class AfterAdvice {
	
	@Pointcut("execution(* com.company.spring..*Impl.get*(..))") //어디에
	public void getpointcut() {}
	
	@AfterReturning(pointcut = "getpointcut()", returning ="returnObj" ) //언제
	public void afterLog(JoinPoint jp, Object returnObj) {// 두번째 매개변수는 리턴값.?
		String method = jp.getSignature().getName();//메서드이름
		System.out.println("[공통로그] after"+ method + "\n" + returnObj);
	}
}
