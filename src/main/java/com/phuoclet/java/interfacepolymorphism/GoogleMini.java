package com.phuoclet.java.interfacepolymorphism;

public class GoogleMini implements Alarm {
    public void ask(){
        System.out.println("How is the weather outside?");
    }

    public void setAlarm(){
        System.out.println("Google Mini Setting an alarm @7:");
    }

}
