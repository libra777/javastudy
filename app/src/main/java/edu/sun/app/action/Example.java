package edu.sun.app.action;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Component(value = "example")
@Scope("session")
public class Example {

    private List<String> names = new ArrayList<String>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String address;

    public void hello() {

        UserFilter userFilter;
        Realm realm = new Realm() {
            public String getName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean supports(AuthenticationToken token) {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        if (StringUtils.hasText(name)) {
            this.names.add(name);
        }

        address = new Date().toString();

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
