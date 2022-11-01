package com.spring.study.multiThread;

public class MultiThreadTest{

    int count = 0;

    public synchronized void m(){
        while(true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadTest t = new MultiThreadTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(runnable,"T1").start();
        Thread.sleep(2000);
        new Thread(runnable,"T2").start();

    }
}
