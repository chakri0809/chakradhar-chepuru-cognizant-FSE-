package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// Exercise 3 & 8: Aspect for logging method execution times and advice
@Aspect
public class LoggingAspect {

    // Exercise 8: Advice before method execution
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(org.aspectj.lang.JoinPoint joinPoint) {
        System.out.println("[LOG] Before executing: " + joinPoint.getSignature().getName());
    }

    // Exercise 8: Advice after method execution
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(org.aspectj.lang.JoinPoint joinPoint) {
        System.out.println("[LOG] After executing: " + joinPoint.getSignature().getName());
    }

    // Exercise 3: Around advice to measure execution time
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
