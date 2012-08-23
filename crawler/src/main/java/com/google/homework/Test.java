package com.google.homework;

import javax.jms.JMSException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) throws JMSException, Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(500);

        for (int i = 0; i < 500; i++) {
            executorService.execute(new ProducerTool());
        }

        while (!executorService.awaitTermination(10, TimeUnit.MINUTES)) {

        }


        // 延时500毫秒之后停止接受消息
        //sleep(500);
        //consumer.close();
    }
}