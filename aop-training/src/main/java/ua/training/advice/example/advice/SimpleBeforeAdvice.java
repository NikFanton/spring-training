package ua.training.advice.example.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import ua.training.advice.example.MessageWriter;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        proxy.writeMessage();
    }
}
