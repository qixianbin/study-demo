package com.spring.study.designpatterns.singletonpattern;

/**
 * 单例模式：懒汉式-dcl方式
 *      需要加volatile，起到禁止指令重排序的问题，避免在new的时候返回半初始化的对象
 *      构造方法私有化，防止外部方法采用new的形式创建对象
 */
public class SingletonDCL {
    
    private static volatile SingletonDCL singletonDCL = null;
    
    private SingletonDCL(){};
    
    public static SingletonDCL  getInstance(){
        if(singletonDCL == null){
            synchronized (SingletonDCL.class){
                if(singletonDCL == null){
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}
