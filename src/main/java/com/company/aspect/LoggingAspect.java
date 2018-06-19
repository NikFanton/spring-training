package com.company.aspect;

import org.aspectj.lang.JoinPoint;


public class LoggingAspect {

    private void allLogEventMethods() {
        System.out.println("execution");
    }

    public void logBefore(JoinPoint joinPoint) {
        System.out.println("before");
    }

    public void logAfter() {
        System.out.println("after");
    }

    public void LogAfterThrow(Throwable ex) {

    }
}
