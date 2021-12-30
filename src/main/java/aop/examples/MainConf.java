package aop.examples;

import aop.examples.aop.CustomPointcut;
import aop.examples.aop.ExceptionHandlerAspect;
import aop.examples.services.StartService;
import org.springframework.context.annotation.*;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
//@ImportResource("classpath:aop.xml")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class MainConf {






    public static void main(String[] args) {

        //todo solve the problem that each exception handled more than once
        //todo write an aspect which support @Cachable annotation and/or @Retry(repeat=3, interval=1000)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);

        StartService bean = context.getBean(StartService.class);
        try {
            bean.start();
        } catch (Exception e) {
            System.out.println("problem, we will try again later");
        }
    }




}
