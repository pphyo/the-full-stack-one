package com.codoverse.aops.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.codoverse.aops.service.AspectService.*(..))")
	public void select() {}
	
//	@Before("select()")
//	public void logBefore() {
//		IO.println("Running before method");
//	}
//	
//	@After("select()")
//	public void logAfter() {
//		IO.println("Running after method");
//	}
//	
//	@AfterReturning(value = "select()", returning = "result")
//	public void logAfterReturning(String result) {
//		IO.println("Running after returing method with " + result);
//	}
//	
//	@AfterThrowing(value = "select()")
//	public void logAfterThrowing() {
//		IO.println("Running after throwing");
//	}
	
	@Around(value = "execution(* com.codoverse.aops.service.AspectService.withString(String, ..))")
	public Object logAroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		
		// before
		IO.println("\n[Around Advice] -> Preparing to start original method...");
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			
			IO.println("[Around Advice] -> invoke proceed() and send jobs to original method.");
			
			result = jp.proceed(); // running original method
			
			// after returning
			IO.println("[Around Advice] -> Finished original method's jobs");
			
			result = result + " [Adding some extra text from AOP.]";
			
		} catch (Exception e) {
			// after throwing
			IO.println("[Around Advice] -> Intercept and catch the error: " + e.getMessage());
			throw e;
		}
		
		// after
		long end = System.currentTimeMillis();
		long duration = end - start;
		IO.println("[Around Advice] -> Duration: " + duration);
		
		return result;
	}

}
