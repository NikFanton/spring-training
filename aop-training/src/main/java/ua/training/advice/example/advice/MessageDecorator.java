package ua.training.advice.example.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello, ");
        Object returnValue = methodInvocation.proceed();
        System.out.println("!");
        return returnValue;
    }
}
