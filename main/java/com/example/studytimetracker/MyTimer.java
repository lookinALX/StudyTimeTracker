package com.example.studytimetracker;

import javafx.scene.control.Label;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyTimer {
    private int hour;
    private int minute;
    private int second;
    private int passedTime = 0;

    public MyTimer(){

    }

    public MyTimer(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTimer(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public boolean endTimeCheck(){
        if(hour == 0 && minute == 0 && second == 0){
            return true;
        } else return false;
    }

    public String getTime(){
        String time;
        if(hour > 0){
            time = String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second);
        } else {
            time = String.valueOf(minute) + ":" + String.valueOf(second);
        }
        return time;
    }

    public String getPastTime(){
        String time;
        int seconds;
        int hours = passedTime/3600;
        int minutes = (passedTime%3600)/60;

        if(passedTime >= 60) {
            seconds = passedTime%3600 - 61;
        } else {
            seconds = passedTime%3600-1;
        }

        time = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);

        return time;
    }

    public void addSecond(){
        passedTime ++;
    }

    public void previousSecond(){
        second --;
        if(-1 == second){
            minute --;
            second = 59;
        }if(-1 == minute){
            hour --;
            minute = 59;
        }
    }

}
