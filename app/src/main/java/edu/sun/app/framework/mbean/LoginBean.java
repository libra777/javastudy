package edu.sun.app.framework.mbean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: sunqipeng
 * Date: 12-10-8
 */
@Component
public class LoginBean {


    private static Logger logger = LoggerFactory.getLogger(LoginBean.class);

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }


    public String login() {
        logger.info("user login " + SecurityUtils.getSubject());
        return "/home";
    }
}
