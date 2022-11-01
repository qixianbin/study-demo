package com.spring.study.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLauchTest {

    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 执行");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
                System.out.println("t1 end");
            }
        },"t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 执行");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
                System.out.println("t2 end");
            }
        },"t2");
        thread1.start();
        thread2.start();

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 执行");
    }
}
