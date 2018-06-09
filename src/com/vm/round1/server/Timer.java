package com.vm.round1.server;

import java.util.Date;

public class Timer {

    public Timer() {
    }

    public String getCurrentDateAndTime() throws InterruptedException {
//        Thread.sleep(1000);
        final String dateTime = new Date().toString();
        System.out.println("DateTime found : " + dateTime);
        return dateTime;
    }
}
