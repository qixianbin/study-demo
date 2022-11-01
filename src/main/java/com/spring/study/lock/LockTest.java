package com.spring.study.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockTest {

    List<Object> list = new ArrayList<>();
    static Thread t1,t2;

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Object o = new Object();

        //线程1打印
        t1 = new Thread(() -> {
            System.out.println("t1 start");
//            synchronized (o){
                for (int i = 0; i < 10; i++) {
                    lockTest.list.add(new Object());
                    System.out.println(lockTest.list.size());
                    if (lockTest.list.size() == 5) {
//                        o.notify();
//                        try {
//                            o.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        LockSupport.unpark(t2);
                        LockSupport.park();

                    }
                }
//            }
        }, "t1");

        t2 = new Thread(() -> {
            System.out.println("t2 start" + lockTest.list.size());
//            synchronized (o){
                if (lockTest.list.size() != 5){
//                    try {
//                        o.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    LockSupport.park();
                }
                System.out.println("t2 end");
//                o.notify();
                LockSupport.unpark(t1);
//            }
        }, "t2");

        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}
