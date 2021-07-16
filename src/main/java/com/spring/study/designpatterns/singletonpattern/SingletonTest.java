package com.spring.study.designpatterns.singletonpattern;

public class SingletonTest {
    public static void main(String[] args) {
        
        //DCL验证
        SingletonDCL singletonDCL = SingletonDCL.getInstance();
        SingletonDCL singletonDCL2 = SingletonDCL.getInstance();
        System.out.println("singletonDCL == singletonDCL2 :" + (singletonDCL == singletonDCL2));
        
        //饿汉式验证
        SingletonEhan singletonEhan = SingletonEhan.getInstance();
        SingletonEhan singletonEhan2 = SingletonEhan.getInstance();
        System.out.println("singletonEhan == singletonEhan2 :" + (singletonEhan == singletonEhan2));
        
        //静态内部类验证
        SingletonStatic singletonStatic = SingletonStatic.getInstance();
        SingletonStatic singletonStatic1 = SingletonStatic.getInstance();
        System.out.println("singletonStatic == singletonStatic1 :" + (singletonStatic == singletonStatic1));
    }
}
