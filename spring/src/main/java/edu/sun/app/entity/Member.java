package edu.sun.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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

    private boolean working;
    @OneToMany(mappedBy = "member")
    private List<Vacation> vacationList;

    public List<Vacation> getVacationList() {
        return vacationList;
    }

    public void setVacationList(List<Vacation> vacationList) {
        this.vacationList = vacationList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
