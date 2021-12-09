package com.idi.idicoronaservice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(1)
public class GammaCoronaDoctor implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {
        System.out.println("Gamma was fixed");
    }
}
