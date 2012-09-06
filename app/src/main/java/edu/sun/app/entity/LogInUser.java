package edu.sun.app.entity;

import javax.persistence.*;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Entity
@Table(name = "t_loginuser")
public class LoginUser {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String answer;
    private String question;

    @OneToOne(mappedBy = "loginUser")
    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
