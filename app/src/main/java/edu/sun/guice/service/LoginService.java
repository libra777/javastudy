package edu.sun.guice.service;

import com.google.inject.Singleton;

/**
 * User: sunqipeng
 * Date: 12-9-9
 */

public interface LoginService {
    public boolean login(String name, String pwd);

    public void addUser(String name, String pwd);
}
