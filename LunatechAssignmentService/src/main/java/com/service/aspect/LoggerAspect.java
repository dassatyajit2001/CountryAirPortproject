package com.service.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.service.processor.CommonProcessorImpl;

@Aspect
@Component
public class LoggerAspect {
	
	private Logger processorlog=LoggerFactory.getLogger(CommonProcessorImpl.class);
	
	@Before("execution(* com.service.processor.CommonProcessorImpl.*(..)")
	public void methodProcessorInputLog(JoinPoint joinpoint)
	{
		processorlog.info("Entering: "+joinpoint.getSignature().getName(),joinpoint.getArgs());
	}
	
	@Before("execution(* com.service.processor.CommonProcessorImpl.*(..)")
	public void methodprocessorExitLog(JoinPoint joinpoint)
	{
		processorlog.info("Exiting: "+joinpoint.getSignature().getName(),joinpoint.getArgs());
	}
	
	@AfterThrowing(pointcut=("execution(* com.service.processor.CommonProcessorImpl.*(..)"),throwing="ex")
	public void methodprocessorExceptionLog(Exception ex) throws Throwable
	{
		processorlog.error(ex.getMessage(),ex);
	}
	
	@Before("execution(* com.service.db.dao.CommonProcessorImpl.*(..)")
	public void methodLoggerInputLog(JoinPoint joinpoint)
	{
		processorlog.info("Entering: "+joinpoint.getSignature().getName(),joinpoint.getArgs());
	}
	
	@Before("execution(* com.service.db.dao.CommonProcessorImpl.*(..)")
	public void methodloggerExitLog(JoinPoint joinpoint)
	{
		processorlog.info("Exiting: "+joinpoint.getSignature().getName(),joinpoint.getArgs());
	}

}
