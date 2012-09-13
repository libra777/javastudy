package edu.sun.app.utils;

import edu.sun.app.entity.Member;

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
            days = 0;
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


        if (workLongType == 1) {
            days += 0;
        }
        if (workLongType == 2) {
            int pastedYear = DateUtils.pastedYears(member);
            if (pastedYear == 1) {
                days += 3;
            }
            if (pastedYear == 2) {
                days += 4;
            }
            if (pastedYear == 3) {
                days += 5;
            }
            if (pastedYear == 4) {
                days += 7;
            }
            if (pastedYear == 5) {
                days += 9;
            }
            if (pastedYear >= 6) {
                days += 10;
            }


        }

        if (workLongType == 2) {
            int pastedYear = DateUtils.pastedYears(member);

            if (pastedYear == 4) {
                days += 2;
            }
            if (pastedYear == 5) {
                days += 4;
            }
            if (pastedYear >= 6) {
                days += 5;
            }

        }
        return days;

    }
}
