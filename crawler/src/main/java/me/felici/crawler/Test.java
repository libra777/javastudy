package me.felici.crawler;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * User: sunqipeng
 * Date: 12-8-24
 */
public class Test {
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext initialContext = new InitialContext();
        System.out.println(initialContext);

        Object object = initialContext.lookup("hello");
        System.out.println(object);
        QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) object;
        QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
        QueueSession queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);

    }
}
