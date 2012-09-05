package edu.sun.webbean;

import javax.enterprise.inject.Model;

/**
 * User: sunqipeng
 * Date: 12-9-5
 */
@Model
public class LoginUser {
    private String name;
    private String password;

    public String getName() {

        return name + "test";
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
}
