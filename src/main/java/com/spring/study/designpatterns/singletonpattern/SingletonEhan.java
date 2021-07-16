package com.spring.study.designpatterns.singletonpattern;

/**
 * 单例模式：饿汉式
 *      饿汉式，空间换时间，加载类的时候就创建好单例对象，不存在线程安全问题
 */
public class SingletonEhan {
    
    private static final SingletonEhan singletonEhan = new SingletonEhan();
    
    private SingletonEhan(){};
    
    public static SingletonEhan getInstance(){
        return singletonEhan;
    }
    
}
