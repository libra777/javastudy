package edu.sun.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
@Entity
public class Vacation {

    @Id
    @GeneratedValue
    private Integer id;
    private String desc;
    private Date logDate;
    private String logYear;
    private float days;

    @ManyToOne
    private Member member;

    public float getDays() {
        return days;
    }

    public void setDays(float days) {
        this.days = days;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogYear() {
        return logYear;
    }

    public void setLogYear(String logYear) {
        this.logYear = logYear;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
