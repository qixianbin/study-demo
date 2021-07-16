package com.spring.study.designpatterns.singletonpattern;

/**
 * 单例模式：静态内部类方式
 *      优点：利用静态内部类在调用的时候才进行加载的机制来实现懒加载和线程安全
 *      缺点：外部无法传递参数进去
 */
public class SingletonStatic {
    
    private SingletonStatic(){};
    
    private static class SingletonStaticHolder{
        private static SingletonStatic singletonStatic = new SingletonStatic();
    }
    
    public static SingletonStatic getInstance(){
        return SingletonStaticHolder.singletonStatic;
    }
    
}
