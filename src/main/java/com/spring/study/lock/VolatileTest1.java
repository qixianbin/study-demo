package com.spring.study.lock;

import java.util.concurrent.TimeUnit;

public class VolatileTest1 {

    /*volatile */boolean flag = true;
    volatile int IFlag = 1;

    public void m(){
        System.out.println("start");
//        while(flag){
//
//        }
        while(IFlag == 1){

        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest1 t = new VolatileTest1();
        new Thread(() -> t.m(),"T1").start();

        TimeUnit.SECONDS.sleep(1);

//        t.flag = false;
        t.IFlag = 2;
        Thread.sleep(100000);
    }
}
