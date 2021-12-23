package aop.examples;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */
@Configuration
@Profile("DEV")
@PropertySource("classpath:devmails.properties")
//spring.profiles.active = PROD,WEB
public class DevConf {
}
