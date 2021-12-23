package aop.examples.aop;

import aop.examples.validators.IdiException;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class ExceptionHandlerAspect {


    private List<String> mails;


    @Value("${dba.mails}")
    public void setMails(String[] mails) {
        this.mails = asList(mails);
    }


    @AfterThrowing(pointcut = "execution(* aop.examples..*.*(..))",throwing = "ex")
    public void handleIdiExceptions(IdiException ex) {
        for (String mail : mails) {
            System.out.println("mail with exception: " + ex.getMessage() + " sent to " + mail);
        }
    }



  /*  @Around("execution(* aop.examples.validators.*.*(..))")
    @SneakyThrows
    public Object handleIdiExceptions(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (IdiException e) {
            for (String mail : mails) {
                System.out.println("mail with exception: " + e.getMessage() + " sent to " + mail);
            }
            throw e;
        }

    }*/
}



