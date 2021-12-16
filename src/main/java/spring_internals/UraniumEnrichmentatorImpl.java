package spring_internals;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

@Loggable
@Component("enrichmentator")
public class UraniumEnrichmentatorImpl  implements UraniumEnrichmentator{

    @Setter
    @InjectRandom(min = 10, max = 15)
    private int number = 100;


    public UraniumEnrichmentatorImpl() {
        System.out.println("Phase 1 enrichmentator constructor is working");
    }

    @PostConstruct
    private void init() {
        System.out.println("phase 2: init is working... " + number);
    }

    @Override
    @Scheduled(fixedDelay = 500)
    @Loggable
    public void enrich() {
        System.out.println("enriching generator " + number);
        throw new SybaseRuntimeException("fire all");
    }
}
