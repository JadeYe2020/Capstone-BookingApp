package com.example.bookingapp;

import java.util.HashMap;
import java.util.List;

public class SelectRunnable  implements Runnable{

    private volatile List<Person> person;

    @Override
    public void run() {
        person=null;
    }

    // to get value
    public List<Person> getValue() {
        return person;
    }

}

