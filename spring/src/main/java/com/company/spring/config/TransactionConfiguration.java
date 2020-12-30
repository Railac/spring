package com.company.spring.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;


@Configuration
@EnableAspectJAutoProxy
public class TransactionConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConfiguration.class);
	private static final int TX_METHOD_TIMEOUT = 3;
	private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.company..service.impl.*ServiceImpl.*(..))";

	@Autowired
	//private PlatformTransactionManager transactionManager;
	private DataSourceTransactionManager transactionManager;

	@Bean
	public TransactionInterceptor txAdvice() { //어드바이스 빈등록
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		Properties txAttributes = new Properties();
		List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
		rollbackRules.add(new RollbackRuleAttribute(Exception.class));

		/** If need to add additionall exceptio, add here **/
		DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(
				TransactionDefinition.PROPAGATION_REQUIRED);
		readOnlyAttribute.setReadOnly(true);
		readOnlyAttribute.setTimeout(TX_METHOD_TIMEOUT);
		RuleBasedTransactionAttribute writeAttribute = 
				new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
		writeAttribute.setTimeout(TX_METHOD_TIMEOUT);

		String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
		String writeTransactionAttributesDefinition = writeAttribute.toString();

		//read only, 파란글자로되어있는것은 트랙잭션처리 제외(read only)
		txAttributes.setProperty("retrieve*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("select*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("get*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("list*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("search*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("find*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("count*", readOnlyTransactionAttributesDefinition);

		// write rollback-rule, 그외나머지는 트랜잭션 처리
		txAttributes.setProperty("*", writeTransactionAttributesDefinition);
		txAdvice.setTransactionAttributes(txAttributes);
		txAdvice.setTransactionManager(transactionManager);
		return txAdvice;
	}

	@Bean
	public Advisor txAdviceAdvisor() { //어드바이스에 포인트컷 설정
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		// pointcut.setExpression("(execution(* *..*.service..*.*(..)) ||
		// execution(* *..*.services..*.*(..)))");
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
}
