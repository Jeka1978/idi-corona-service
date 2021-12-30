package aop.examples;

import aop.examples.aop.CustomPointcut;
import aop.examples.aop.ExceptionDistributor;
import aop.examples.aop.ExceptionHandlerAspect;
import aop.examples.aop.MailExceptionDistributor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Evgeny Borisov
 */
@Configuration
//@Profile("AOP")
public class AopConfig {

    @Bean
    @ConditionalOnMissingBean
    public ExceptionDistributor mailExceptionDistributor(){
        return new MailExceptionDistributor();
    }

    @Bean
    public CustomPointcut customPointcut(){
        return new CustomPointcut();
    }

    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(customPointcut(), exceptionHandlerAspect());
    }











}
