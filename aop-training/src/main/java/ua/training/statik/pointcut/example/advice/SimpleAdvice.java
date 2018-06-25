package ua.training.pointcut.example.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoke method " + methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        System.out.println(">> Done");
        return returnValue;
    }
}
