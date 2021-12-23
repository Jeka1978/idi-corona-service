package aop.examples.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class LogAspect {


    @After("execution(* aop.examples..*.validate(..))")
    public void logValidateMethods(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        System.out.println("method of validator "+className+" finished working");
    }

}
