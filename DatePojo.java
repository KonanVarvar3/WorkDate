package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

public class DatePojo {

    private int day;
    private int month;
    private int year;

    DatePojo(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    DatePojo(){}

    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }
}
