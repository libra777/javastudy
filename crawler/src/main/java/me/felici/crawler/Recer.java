package me.felici.crawler;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: sunqipeng
 * Date: 8/31/12
 */
public class Recer implements MessageListener, Runnable {
    public void onMessage(Message message) {
        try {
            System.out.printf("thread %d rec a message, message id %s\n", Thread.currentThread().getId(),
                    message.getJMSMessageID());
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) throws NamingException, JMSException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.execute(new Recer());
        }
    }

    public void run() {
        InitialContext initialContext = null;
        try {
            initialContext = new InitialContext();
            Queue queue = (Queue) initialContext.lookup("target");
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("hello");
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queueSession.createReceiver(queue).setMessageListener(new Recer());
            System.out.println("ready to rec message");
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
