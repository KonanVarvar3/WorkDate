package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

public interface IDateWork {

    boolean isLeapYear(int year);

	boolean isValidDate(int year, int month, int day);

	int getDayOfWeek(int year, int month, int day);

	String toString(int year, int month, int day);

	int countDays(int year, int month, int day);

}
