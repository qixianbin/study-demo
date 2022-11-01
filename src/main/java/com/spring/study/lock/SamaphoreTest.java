package com.spring.study.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SamaphoreTest {
    static int count = 0;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 start");
                try {
                    semaphore.acquire();
                    System.out.println("t1 acquire");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0;i < 10000;i++){
                    count++;
                }
                semaphore.release();
                System.out.println("t1 end");
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 start");
                try {
                    semaphore.acquire();
                    System.out.println("t2 acquire");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0;i < 10000;i++){
                    count++;
                }
                semaphore.release();
                System.out.println("t2 end");
            }
        },"t2");

        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
