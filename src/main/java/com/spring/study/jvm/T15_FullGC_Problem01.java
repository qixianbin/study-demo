package com.spring.study.jvm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T15_FullGC_Problem01 {

    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birthdate = new Date();

        public void m() {}
    }

//    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
//            new ThreadPoolExecutor.DiscardOldestPolicy());
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(50,100,30L,TimeUnit.SECONDS,new ArrayBlockingQueue<>(50),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        executor.setMaximumPoolSize(50);

        for (;;){
            modelFit();
            Thread.sleep(100);
        }
    }

    private static void modelFit(){
        List<CardInfo> taskList = getAllCardInfo();
        taskList.forEach(info -> {
            // do something
//            executor.scheduleWithFixedDelay(() -> {
//                //do sth with info
//                info.m();
//
//            }, 2, 3, TimeUnit.SECONDS);
            executor.execute(() -> {
                //do sth with info
                info.m();

            });
        });
    }

    private static List<CardInfo> getAllCardInfo(){
        List<CardInfo> taskList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CardInfo ci = new CardInfo();
            taskList.add(ci);
        }

        return taskList;
    }
}