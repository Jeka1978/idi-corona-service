package com.idi.idicoronaservice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(2)
public class DeltaCoronaDoctor implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {

        //todo 50 lines
        System.out.println("code runs and threat from delta mutation...");
    }
}
