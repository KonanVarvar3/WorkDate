package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

public enum Month {
    JANUARY("January", 5),
    FEBRUARY("February", 1),
    MARCH("March", 1),
    APRIL("April", 4),
    MAY("May", 6),
    JUNE("June", 2),
    JULY("July", 4),
    AUGUST("August", 0),
    SEPTEMBER("September", 3),
    OCTOBER("October", 5),
    NOVEMBER("November", 1),
    DECEMBER("December", 3);

    private String month;
    private int code;

    Month(String month, int code) {
        this.month = month;
        this.code = code;
    }

    public String getValue(int index) {
        return month;
    }

    public int getCode(int index) {
        return code;
    }
}
