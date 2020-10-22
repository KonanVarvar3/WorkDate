package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

public interface IDateWork {

    boolean isLeapYear(int year);

    boolean isValidDate(int year, int month, int day);

    int getDayOfWeek(int year, int month, int day) throws IsValidDateExeption;

    String toString(int year, int month, int day) throws IsValidDateExeption;

    int countDays(int year, int month, int day);

}
