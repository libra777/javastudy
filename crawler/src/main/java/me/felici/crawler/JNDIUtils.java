package me.felici.crawler;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * User: sunqipeng
 * Date: 12-9-1
 */
public class JNDIUtils {

    private static InitialContext initialContext;

    static {
        try {
            initialContext = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Object getObject(String object) throws NamingException {

        return initialContext.lookup(object);
    }
}
