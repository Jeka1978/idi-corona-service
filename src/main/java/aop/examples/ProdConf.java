package aop.examples;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */
@Configuration
@Profile("PROD")
@PropertySource("classpath:mails.properties")
public class ProdConf {
}
