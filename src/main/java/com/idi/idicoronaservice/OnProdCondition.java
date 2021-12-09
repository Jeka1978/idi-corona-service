package com.idi.idicoronaservice;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Evgeny Borisov
 */
public class OnProdCondition implements Condition {

    private static Boolean answer;
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        if (answer == null) {

            //todo check addresses of servers and put true to the answer variable
        }

        return answer;
    }
}
