package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(org.aspectj.lang.JoinPoint joinPoint) {
        System.out.println("[LOG] Before executing: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(org.aspectj.lang.JoinPoint joinPoint) {
        System.out.println("[LOG] After executing: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("[LOG] " + joinPoint.getSignature().getName()
                + " executed in " + duration + "ms");
        return result;
    }
}
