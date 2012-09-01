package me.felici.crawler;

import javax.naming.NamingException;

/**
 * User: sunqipeng
 * Date: 12-9-1
 */
public class App {
    public static void main(String[] arg) throws NamingException {
        System.out.println("init the application");
        System.out.println(JNDIUtils.getObject("hello"));
        System.out.println("application over");
    }
}
