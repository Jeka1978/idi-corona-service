package spring_internals;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
//@Aspect
//@Component
public class LoggingAspect {

    //todo
    //write an aspect which will send an email (don't really send, just print that you did it)
    //to all people which mails appear in mails.properties everytime, when SybaseRuntimeException happens
    //check that aspect handle exception only once per each problem



    @Before("@annotation(Loggable)")
    public void handleLoggedMethods(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+" started ***************");
    }
}
