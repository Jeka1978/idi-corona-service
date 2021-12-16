package spring_internals;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */
@Component
public class LoggableSupportBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Loggable.class)) {


            if (beanClass.getInterfaces().length == 0) {
               return Enhancer.create(beanClass, (InvocationHandler) (o, method, args) -> {

                   return invoce(bean, method, args);

               });
            }

            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                    , beanClass.getInterfaces()
                    , (proxy, method, args) -> {

                        return invoce(bean, method, args);
                    });
        }

        return bean;
    }

    private Object invoce(Object bean, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("***** starting logging for method " + method.getName() + "   *********");
        long start = System.nanoTime();
        Object retVal = method.invoke(bean, args);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("***** ended logging for method " + method.getName() + "   *********");
        return retVal;
    }
}
