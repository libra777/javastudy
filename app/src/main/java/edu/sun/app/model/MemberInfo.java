package edu.sun.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class MemberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 48)
    @NotEmpty
    @Size(max = 48)
    private String name;

    private String memberId;
    private long workLong;
    private Date enternDate;
    private Date leaveDate;
    private boolean working;

    @OneToMany()
    private List<MemberInfo> memberInfoList;

    public Date getEnternDate() {
        return enternDate;
    }

    public void setEnternDate(Date enternDate) {
        this.enternDate = enternDate;
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

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public long getWorkLong() {
        return workLong;
    }

    public void setWorkLong(long workLong) {
        this.workLong = workLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
