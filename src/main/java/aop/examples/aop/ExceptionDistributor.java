package aop.examples.aop;

import aop.examples.validators.IdiException;

/**
 * @author Evgeny Borisov
 */
public interface ExceptionDistributor {
    void deliverException(IdiException ex);
}
