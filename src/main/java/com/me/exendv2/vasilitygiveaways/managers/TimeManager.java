package com.me.exendv2.vasilitygiveaways.managers;

public class TimeManager {

    public String getDurationString(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        String hourss = "";
        String minutess = "";
        String secondss = "";

        if (hours == 1) {
            hourss = hours + " hour ";
        }
        if (hours > 1) {
            hourss = hours + " hours ";
        }
        if (hours <= 0) {
            hourss = "";
        }
        if (minutes == 1) {
            minutess = minutes + " minute ";
        }
        if (minutes > 1) {
            minutess = minutes + " minutes ";
        }
        if (minutes <= 0) {
            minutess = "";
        }
        if (seconds == 1) {
            secondss = seconds + " second";
        }
        if (seconds > 1) {
            secondss = seconds + " seconds";
        }
        if (seconds <= 0) {
            secondss = "";
        }
        return hourss + minutess + secondss;
    }

}
