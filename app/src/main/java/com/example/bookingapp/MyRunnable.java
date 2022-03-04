package com.example.bookingapp;

import java.util.HashMap;

public class MyRunnable implements Runnable {

    private volatile int count;
    private volatile HashMap<String, Integer> map;
    @Override
    public void run() {
        count = 0;
    }

    // to get value
    public int getValue() {
        return count;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}
