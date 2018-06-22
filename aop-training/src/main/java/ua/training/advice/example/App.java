package ua.training.advice.example;

import org.springframework.aop.framework.ProxyFactory;
import ua.training.advice.example.advice.MessageDecorator;

public class App {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(target);
        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        target.writeMessage();
        System.out.println();
        proxy.writeMessage();
    }
}
