package com.netckracker.edu.dvorianchicov.tricky_tasks.work_dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class for work with dates
 *
 * @author Dvorianchicov Sergey
 */
public class DateWork implements IDateWork {

    @Override
    public boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year value can not be less than 0");
        }

        if ((year % 4) == 0 && (year % 100) != 0) {
            return true;
        } else if ((year % 4) == 0 && (year % 100) == 0 && (year % 400) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {
        if (year >= 0 && month < 13 && month > 0 && day > 0 && day < 32) {
            if (month == 4 || month == 6 || month == 9 || month == 11 && day < 31) {
                return true;
            } else if (isLeapYear(year) && month == 2 && day < 30) {
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) throws IsValidDateExeption {
        if (!isValidDate(year, month, day)) {
            throw new IsValidDateExeption("Incorrect date");
        }
        int codeMonth = 0;

        Month[] m = Month.values();
        codeMonth = m[month - 1].getCode(month - 1);

        if (isLeapYear(year) && month == 1) {
            codeMonth = 4;
        } else if (isLeapYear(year) && month == 2) {
            codeMonth = 0;
        }

        /*
        int codeCentury = 0;
        int countCentury=year;
        int firstTwoNumbers = year/100;

        while((countCentury%4)==0){
            countCentury++;
        }
        codeCentury = ((countCentury-1)-firstTwoNumbers)*2;

        int lastTwoNumbers = year%100;

        int codeYear = (codeCentury+lastTwoNumbers+lastTwoNumbers/4) % 7;
         */
        /**
         * This formula <code>int codeYear = (int) ((year * 1.25) % 7);</> works the same as above,
         * but shorter and uses different coefficients for months
         */
        int codeYear = (int) ((year * 1.25) % 7);
        int dayOfWeek = (day + codeMonth + codeYear) % 7;

        return dayOfWeek - 1;
    }

    /**
     * Date formatting to a specific form
     */
    @Override
    public String toString(int year, int month, int day) throws IsValidDateExeption {

        if (!isValidDate(year, month, day)) {
            throw new IsValidDateExeption("Incorrect date");
        }

        //create enum arrays
        Day[] d = Day.values();
        Month[] m = Month.values();

        //get string value from array of enumerations
        //calculate the index using the function getDayOfWeek(year,month,day)
        return d[getDayOfWeek(year, month, day)].getValue(getDayOfWeek(year, month, day)) +
                " " + day + " " + m[month].getValue(month) + " " + year;
    }

    /**
     * Date formatting to a specific form
     */
    public String toStrForDate(int year, int month, int day) {

        return year + "-" + month + "-" + day;
    }

    /**
     * Counts the number of days that have passed from the entered date to the current
     */
    @Override
    public int countDays(int year, int month, int day) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expDate = null;
        String expiryDate = toStrForDate(year, month, day);

        int diff = 0;

        try {
            expDate = formatter.parse(expiryDate);
            Calendar cal = Calendar.getInstance();
            int today = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(expDate);
            diff = today - cal.get(Calendar.DAY_OF_MONTH);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return diff;
    }
}
