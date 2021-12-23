package aop.examples.validators;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class ValidatorImpl1 implements Validator {
    @Override
    public void validate() {
        System.out.println("1 say that its ok");
    }
}
