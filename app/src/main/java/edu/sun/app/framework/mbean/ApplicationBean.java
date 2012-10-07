package edu.sun.app.framework.mbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User: sunqipeng
 * Date: 12-10-7
 */
@Component
@Scope("application")
public class ApplicationBean {

    private String applicationName = "Application";

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
