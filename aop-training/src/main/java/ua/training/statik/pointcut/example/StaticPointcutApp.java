package ua.training.statik.pointcut.example;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import ua.training.statik.pointcut.example.advice.SimpleAdvice;
import ua.training.statik.pointcut.example.beans.BeanOne;
import ua.training.statik.pointcut.example.beans.BeanTwo;
import ua.training.statik.pointcut.example.pointcut.SimpleStaticPointcut;

public class StaticPointcutApp {
    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();
        BeanOne proxyOne;
        BeanTwo proxyTwo;

        SimpleStaticPointcut staticPointcut = new SimpleStaticPointcut();
        SimpleAdvice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(staticPointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(beanOne);
        proxyOne = (BeanOne) proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(beanTwo);
        proxyTwo = (BeanTwo) proxyFactory.getProxy();

        proxyOne.foo();
        proxyTwo.foo();
        proxyOne.bar();
        proxyTwo.bar();
    }
}
