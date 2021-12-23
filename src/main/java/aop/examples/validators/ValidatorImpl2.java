package aop.examples.validators;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class ValidatorImpl2 implements Validator {
    @Override
    public void validate() {
        System.out.println("2 say that its ok");
        throw new IdiException("problem");
    }
}
