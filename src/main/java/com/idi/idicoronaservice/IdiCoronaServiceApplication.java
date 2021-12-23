package com.idi.idicoronaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IdiCoronaServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IdiCoronaServiceApplication.class, args);
        System.out.println();
        CoronaHospital hospital = context.getBean(CoronaHospital.class);
        hospital.treat();
        hospital.changeToNextMutation();
        hospital.treat();
    }

}
