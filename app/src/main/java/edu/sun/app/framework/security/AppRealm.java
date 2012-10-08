package edu.sun.app.framework.security;

import edu.sun.app.entity.LogInUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: sunqipeng
 * Date: 12-10-8
 */
public class AppRealm extends AuthorizingRealm {
    static Logger logger = LoggerFactory.getLogger(AppRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("the shiro invoke the realm application");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("the shiro invoke the realm application");
        logger.info(token.getPrincipal().toString());
        logger.info(token.getCredentials().toString());
        logger.info(token.toString());
        return new SimpleAuthenticationInfo(new LogInUser(), token.getCredentials(), this.getName());
    }
}
