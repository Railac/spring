package com.dbal.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //Bean등록 / <beans:beans />
@Aspect //xml에 <aop:aspect />를 쓰거나 이렇게 쓰거나.
public class LogAdvice {
	/* xml에서 이렇게 쓰는걸 아래처럼 쓰면 된다.
	 * <aop:aspect ref="aroundAdvice"> 
	 * <aop:around method="aroundLog" pointcut-ref="all-pointcut"/> 
	 * </aop:aspect>
	 */
	@Pointcut("execution(* com.dbal.app..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void printLog(JoinPoint jp) {	
		String method = jp.getSignature().getName();
		Object[] param = jp.getArgs();
		
		//서비스 실행 전에 이 공통로그를 실행시킨다.
		//이거 아래에 aop:before method="printLog"가 붙음
		System.out.println("[공통로그] before" 
							+ method
							+"\n"
							+((param != null)? param[0] : ""));
	}
}
