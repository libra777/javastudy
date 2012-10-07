package edu.sun.app.framework.mbean;

import edu.sun.app.entity.LogInUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User: sunqipeng
 * Date: 12-10-7
 */
@Component
@Scope("session")
public class SessionBean {

    private LogInUser logInUser;

    public LogInUser getLogInUser() {
        logInUser = new LogInUser();
        logInUser.setName("test User");
        logInUser.setEmail("test@gmail.com");
        return logInUser;
    }

    public void setLogInUser(LogInUser logInUser) {
        this.logInUser = logInUser;
    }
}
