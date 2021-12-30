package aop.examples.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class CustomPointcut extends DynamicMethodMatcherPointcut {

    @Value("${exception.packages}")
    private String packagesToHandle;

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
//        return method.isAnnotationPresent(HandleException.class);
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return clazz.getPackage().getName().contains(packagesToHandle);
            }
        };
    }
}







