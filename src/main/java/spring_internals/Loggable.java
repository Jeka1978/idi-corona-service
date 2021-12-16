package spring_internals;/**
 * @author Evgeny Borisov
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
//methods or classes which marked by this annotation will autoaticly log themself
public @interface Loggable {
}
