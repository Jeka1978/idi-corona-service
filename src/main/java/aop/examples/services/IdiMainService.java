package aop.examples.services;

import aop.examples.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class IdiMainService {

    @Autowired
    private List<Validator> validators;


    public void work(){
        validators.forEach(Validator::validate);
        System.out.println("working...");
    }

}
