package com.vm.round1.server;

import java.time.LocalDateTime;

public class Timer {

    public Timer() {
    }

    public String getCurrentTime() {
        String time = LocalDateTime.now().toString();
        System.out.println("Current time is : " + time);
        return time;
    }
}
