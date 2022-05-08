package com.spring.study.designpatterns.singletonpattern;

import sun.misc.Unsafe;

/**
 * 单例模式：懒汉式-dcl方式
 *      需要加volatile，起到禁止指令重排序的问题，避免在new的时候返回半初始化的对象
 *      构造方法私有化，防止外部方法采用new的形式创建对象
 */
public class SingletonDCL {
    
    private static /*volatile*/ SingletonDCL singletonDCL = null;
    
    private SingletonDCL(){};
    
    public static SingletonDCL   getInstance() throws InterruptedException {
        if(singletonDCL == null){//此处的判断是为了提高效率，不需要加锁就可以得到判断结果
            synchronized (SingletonDCL.class){
                if(singletonDCL == null){
                    Thread.sleep(1000);
                    Unsafe u = Unsafe.getUnsafe();
                    u.storeFence();
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    System.out.println(SingletonDCL.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
