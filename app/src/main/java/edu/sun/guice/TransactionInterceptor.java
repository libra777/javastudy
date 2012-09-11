package edu.sun.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * User: sunqipeng
 * Date: 12-9-9
 */
public class TransactionInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("this method is invoked");
        return null;
    }
}
