package ua.training.statik.pointcut.example.pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import ua.training.statik.pointcut.example.beans.BeanOne;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().equals("foo");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return clazz == BeanOne.class;
            }
        };
    }
}
