package spring_internals;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

//        new ClassPathXmlApplicationContext()


//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");




//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        ConfigurableApplicationContext context = SpringApplication.run(MainConfig.class);
        System.out.println();
//        ConfigurableApplicationContext context = SpringApplication.run(MainConfig.class);

    }
}
