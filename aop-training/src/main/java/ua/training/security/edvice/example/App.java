package ua.training.security.edvice.example;

import org.springframework.aop.framework.ProxyFactory;
import ua.training.security.edvice.example.advice.SecurityAdvice;

public class App {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        SecureBean bean = App.getSecureBean();
        try {
            manager.login("chris", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new SecureBean());
        proxyFactory.addAdvice(new SecurityAdvice());
        return (SecureBean) proxyFactory.getProxy();
    }
}