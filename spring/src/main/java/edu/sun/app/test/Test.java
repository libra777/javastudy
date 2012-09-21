package edu.sun.app.test;

import edu.sun.app.entity.Member;
import edu.sun.app.utils.VacationUtils;

import java.text.ParseException;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        Member member = new Member();


        //member.setEnterDate(DateUtils.parseDate("2002-11-01", "yyyy-MM-dd"));
        member.setWorkLong(6);
        System.out.println(VacationUtils.originalMemberVacation(member));
    }
}
