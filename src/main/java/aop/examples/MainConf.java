package aop.examples;

import aop.examples.services.StartService;
import org.springframework.context.annotation.*;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
//@ImportResource("classpath:aop.xml")
@EnableAspectJAutoProxy
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


    @IdiCache
    public String getPassword(String userName) {

    }

    @IdiCache
    public Person getPerson(int id) {
        //20 lines of code which bring person from database
        return null;
    }









}
