package aop.examples.aop;

import aop.examples.validators.IdiException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */

public class ExceptionHandlerAspect implements MethodInterceptor {

    @Autowired
    private ExceptionDistributor exceptionDistributor;

    private Map<IdiException, Void> exceptions = new WeakHashMap<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        } catch (IdiException ex) {
            if (!exceptions.containsKey(ex)) {
                exceptionDistributor.deliverException(ex);
                exceptions.put(ex, null);
            }
            throw ex;
        }

    }



    /*@AfterThrowing(pointcut = "execution(* com.idi..*.*(..))",throwing = "ex")
    public void handleIdiExceptions(IdiException ex) {
        if (!exceptions.containsKey(ex)) {
            for (String mail : mails) {
                System.out.println("mail with exception: " + ex.getMessage() + " sent to " + mail);
            }
            exceptions.put(ex,null);

        }
    }*/



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



