package edu.sun.guice.action;

import edu.sun.guice.service.LoginService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: sunqipeng
 * Date: 12-9-9
 */
public class LoginController {
    @Inject
    private LoginService loginService;

    @Inject
    @Named(value = "testString")
    private String testString;
    @Inject
    @Named(value = "testString2")
    private String testString2;

    public String getTestString2() {
        return testString2;
    }

    public void setTestString2(String testString2) {
        this.testString2 = testString2;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
