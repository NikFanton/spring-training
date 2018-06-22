package ua.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component("statisticsAspect")
public class StatisticsAspect {
    private Map<Class<?>, Integer> counter;

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {}

    @AfterReturning("allLogEventMethods()")
    public void count(JoinPoint joinPoint) {
        Class<?> clazz = joinPoint.getTarget().getClass();
        if (!counter.containsKey(clazz)) {
            counter.put(clazz, 0);
        }
        counter.put(clazz, counter.get(clazz) + 1);
    }
}
