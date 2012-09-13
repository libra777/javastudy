package edu.sun.app.utils;

import edu.sun.app.entity.Member;

import java.util.Calendar;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
public class VacationUtils {

    /**
     * 剩余的年假
     *
     * @param member
     * @param vacationDays
     * @return
     */
    public static int calculateMemberVacation(Member member, int vacationDays) {
        return originalMemberVacation(member) - vacationDays;
    }

    /**
     * 原有的年假
     *
     * @param member
     * @return
     */
    public static int originalMemberVacation(Member member) {
        int days = 0;
        int workLongType = -1;
        if (member.getWorkLong() < 1) {
            days = 5;
            workLongType = 1;
        }
        if (member.getWorkLong() >= 1 && member.getWorkLong() < 10) {
            workLongType = 2;
            days = 5;
        }
        if (member.getWorkLong() >= 10 && member.getWorkLong() < 20) {
            workLongType = 3;
            days = 10;
        }
        if (member.getWorkLong() >= 20) {
            days = 15;
            workLongType = 4;
        }


        int pastedYear = DateUtils2.pastedYears(member);
        int companyVacation = 0;
        if (workLongType == 1) {
            companyVacation = 3;
        }
        if (workLongType == 2) {

            if (pastedYear == 1) {
                companyVacation = 3;
            }
            if (pastedYear == 2) {
                companyVacation = 4;
            }
            if (pastedYear == 3) {
                companyVacation = 5;
            }
            if (pastedYear == 4) {
                companyVacation = 7;
            }
            if (pastedYear == 5) {
                companyVacation = 9;
            }
            if (pastedYear >= 6) {
                companyVacation = 10;
            }


        }

        if (workLongType == 3) {

            if (pastedYear == 4) {
                companyVacation = 2;
            }
            if (pastedYear == 5) {
                companyVacation = 4;
            }
            if (pastedYear >= 6) {
                companyVacation = 5;
            }

        }

        if (isEnterInThisYear(member.getEnterDate())) {
            return (days * DateUtils2.getDayBeforeYearEnd(member.getEnterDate())) / 365 + (companyVacation * DateUtils2.getDayBeforeYearEnd(member.getEnterDate())) / 365;
        }
        return days + companyVacation;
    }

    private static boolean isEnterInThisYear(Date enterDate) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.setTime(enterDate);
        return calendar.get(Calendar.YEAR) == calendar1.get(Calendar.YEAR);
    }
}
