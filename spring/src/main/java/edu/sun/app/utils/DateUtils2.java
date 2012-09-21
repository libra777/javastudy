package edu.sun.app.utils;

import edu.sun.app.entity.Member;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
public class DateUtils2 {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param enterDate
     * @return
     */
    public static Date parseDate(String enterDate) {

        try {
            return dateFormat.parse(enterDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param enterDate
     * @return
     */
    public static Date parseDate(String enterDate, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(enterDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        if (date == null)
            return "";
        return dateFormat.format(date);
    }

    /**
     * 计算
     *
     * @param member
     * @return
     */
    public static int pastedYears(Member member) {
        return pastedYears(member, new Date());
    }

    /**
     * @param member
     * @param beginDate
     * @return
     */
    public static int pastedYears(Member member, Date beginDate) {

        Calendar enter = Calendar.getInstance();
        //enter.setTime(member.getEnterDate());

        Calendar from = Calendar.getInstance();
        from.setTime(beginDate);

        return from.get(Calendar.YEAR) - enter.get(Calendar.YEAR) + 1;
    }


    /**
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }


    /**
     * @return
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    /**
     * @return
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayBeforeYearEnd(Date date) {
        Calendar endYear = Calendar.getInstance();
        endYear.set(Calendar.DAY_OF_MONTH, 31);
        endYear.set(Calendar.MONTH, 11);
        Calendar entreDate = Calendar.getInstance();
        entreDate.setTime(date);
        return endYear.get(Calendar.DAY_OF_YEAR) - entreDate.get(Calendar.DAY_OF_YEAR);

    }
}
