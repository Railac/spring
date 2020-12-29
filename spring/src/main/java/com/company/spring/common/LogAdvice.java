package com.company.spring.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //<bean>등록
@Aspect //<aop:aspect>
public class LogAdvice {
	@Pointcut("execution(* com.company.spring..*Impl.*(..))") //어디에 적용할것인가.
	public void allpointcut() {}
	
	@Before("allpointcut()") // 포인트컷 지정하고,  언제(before) 지정.
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();//메서드이름
		Object[] param = jp.getArgs(); //파라미터
		System.out.println("[공통로그] before" + method + "\n" + ((param != null && param.length>0)? param[0]:"null"));
	}
}
