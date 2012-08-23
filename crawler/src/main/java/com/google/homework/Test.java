package com.google.homework;

import javax.jms.JMSException;

import static java.lang.Thread.sleep;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) throws JMSException, Exception {
        // TODO Auto-generated method stub
        ConsumerTool consumer = new ConsumerTool();
        ProducerTool producer = new ProducerTool();
        // 开始监听
        consumer.consumeMessage();

        while (true) {
            // 延时500毫秒之后发送消息
            sleep(10);
            producer.produceMessage("Hello, world!");
            producer.close();
        }

        // 延时500毫秒之后停止接受消息
        //sleep(500);
        //consumer.close();
    }
}