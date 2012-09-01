package me.felici.crawler;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * User: sunqipeng
 * Date: 12-8-24
 */
public class Test {
    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
        InitialContext initialContext = new InitialContext();
        Queue queue = (Queue) initialContext.lookup("target");
        QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("hello");
        QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
        queueConnection.start();
        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        QueueSender queueSender = queueSession.createSender(queue);

        while (true) {
            Message me = queueSession.createTextMessage("hello");
            queueSender.send(me);
            Thread.sleep(1000l);
        }

    }
}
