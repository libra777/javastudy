package edu.sun.java;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 30.11.11
 * Time: 17:20
 */
public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
//                "classpath:/META-INF/application-context-root.xml");
//        IRunner runner = ctx.getBean("runner", IRunner.class);
//        runner.run();
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        String value = new Md5Hash("sunming#").toHex();
        System.out.println(value);
        Realm realm = new Realm() {
            @Override
            public String getName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean supports(AuthenticationToken authenticationToken) {

                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

                AuthenticationInfo authenticationInfo;

                return null;  //To change body of implemented methods use File | Settings | File Templates.

            }
        };


        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        DefaultSessionManager defaultSessionManager;

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("sdf", "dsd");

        if (subject.isAuthenticated()) {
            System.out.println(subject.getPrincipal());
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken("root", "secret");
            token.setRememberMe(true);
            subject.login(token);
            subject.checkPermission("v:test");

            if (subject.hasRole("admin")) {
                System.out.println("2222sdfsd");
            } else {
                System.out.println("1111sdfsd");
            }

        }
        //
        AuthenticationToken authenticationToken;

    }

    public static void testApi() {
//        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
//        subject.login(new UsernamePasswordToken());

    }
}
