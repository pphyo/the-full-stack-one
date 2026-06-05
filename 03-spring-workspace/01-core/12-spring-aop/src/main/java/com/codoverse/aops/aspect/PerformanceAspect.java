package com.codoverse.aops.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

	@Around("@annotation(com.codoverse.aops.TrackTime)")
	public Object measureTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		
		IO.println("[Timer] " + jp.getSignature().getName() + " Duration = " + (end - start) + " ms");
		return obj;
	}
	
}
