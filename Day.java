package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

public enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String day;

    public String getValue(int index){
        return day;
    }

    Day(String day){
        this.day=day;
    }
}
