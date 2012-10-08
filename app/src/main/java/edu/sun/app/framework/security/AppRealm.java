package edu.sun.app.framework.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * User: sunqipeng
 * Date: 12-10-8
 */
public class AppRealm implements Realm {
    public String getName() {
        return "apprealm";
    }

    public boolean supports(AuthenticationToken token) {
        if (token instanceof UsernamePasswordToken) {

        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
