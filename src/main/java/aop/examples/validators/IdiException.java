package aop.examples.validators;

/**
 * @author Evgeny Borisov
 */
public class IdiException extends RuntimeException {
    public IdiException(String message) {
        super(message);
    }
}
