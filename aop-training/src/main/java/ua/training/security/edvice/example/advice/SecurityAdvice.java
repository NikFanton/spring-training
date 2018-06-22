package ua.training.security.edvice.example.advice;

import org.springframework.aop.MethodBeforeAdvice;
import ua.training.security.edvice.example.SecurityManager;
import ua.training.security.edvice.example.UserInfo;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " +
                    method.getName());
        } else if (user.getUserName().equals("chris")) {
            System.out.println("Logged In user is chris - OK");
        } else {
            System.out.println("Logged In user is " + user.getUserName() + " - NOT GOOD");
            throw new SecurityException("User " + user.getUserName() + "is not allowed access to method " +
                    method.getName());
        }
    }
}
