package com.spring.study.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VolatileTest2 {

    volatile List list = new ArrayList();

//    List list = new ArrayList();
//    List list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        VolatileTest2 volatileTest2 = new VolatileTest2();
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 启动");
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    //                try {
                    //                    TimeUnit.SECONDS.sleep(1);
                    //                } catch (InterruptedException e) {
                    //                    e.printStackTrace();
                    //                }
                    volatileTest2.list.add(1);
                    System.out.println(volatileTest2.list.size());
                    if(volatileTest2.list.size() == 5){
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            System.out.println("t1 结束");
        },"t1");

        Thread t2 = new Thread(() -> {
            System.out.println("t2 启动");
//            while (true) {
                synchronized (o) {
                    if (volatileTest2.list.size() != 5) {
                        System.out.println("t2 wait");
                        try {
                            o.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(" t2 " + volatileTest2.list.size());

//                        break;
                    }else{
                        System.out.println("t2" + volatileTest2.list.size());
                    }
                    o.notify();
                }
//            }
            System.out.println("t2 结束");

        },"t2");

        t1.start();
//        TimeUnit.SECONDS.sleep(1);
        t2.start();


        TimeUnit.SECONDS.sleep(3);
    }
}
