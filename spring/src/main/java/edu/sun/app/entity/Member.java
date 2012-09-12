package edu.sun.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-9-11
 */
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String memberId;
    private int workLong;
    private Date enterDate;
    private Date leaveDate;
    private boolean working;

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public int getWorkLong() {
        return workLong;
    }

    public void setWorkLong(int workLong) {
        this.workLong = workLong;
    }
}
