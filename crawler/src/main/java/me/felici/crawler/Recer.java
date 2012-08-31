package me.felici.crawler;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * User: sunqipeng
 * Date: 8/31/12
 */
public class Recer implements MessageListener {
    public void onMessage(Message message) {
        System.out.println("receive a message");
    }
}
