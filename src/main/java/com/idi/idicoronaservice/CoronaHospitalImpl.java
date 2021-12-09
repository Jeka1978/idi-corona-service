package com.idi.idicoronaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class CoronaHospitalImpl implements CoronaHospital {


    @Autowired
    private List<CoronaDoctor> coronaDoctors;

    private int index;

    @Override
    public void treat() {
        coronaDoctors.get(index).treatCurrentMutation();
    }

    @Override
    public void changeToNextMutation() {
        index++;
        if (index == coronaDoctors.size()) {
            index=0;
        }
    }
}
