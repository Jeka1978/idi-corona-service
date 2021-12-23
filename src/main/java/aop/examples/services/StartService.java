package aop.examples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class StartService {

    @Autowired
    private IdiMainService mainService;

    public void start(){
        System.out.println("starting...");
        mainService.work();
    }
}
