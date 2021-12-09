package com.idi.idicoronaservice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(3)
public class OxymironCoronaDoctor implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {

        //todo 100 lines
        System.out.println("code runs and threat from oxymeron mutation...");
    }
}
