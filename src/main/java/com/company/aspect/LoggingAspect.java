package com.company;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {
    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
    }

    @AfterReturning(
            pointcut = "allLogEventMethods()",
            returning = "retVal")
    public void logAfter(Object retVal) {
    }

    @AfterThrowing(
            pointcut = "allLogEventMethods()",
            throwing = "ex")
    public void LogAfterThrow(Throwable ex) {

    }
}
