package com.spring.study.designpatterns.templatemethodpattern;

public abstract class AbstractClass {

    public final void method(){
        method1();
        method2();
        if(gouzi()){
            method3();
        }

        method4();
    }

    public void method1(){
        System.out.println("倒水");
    }

    public abstract void method2();

    public abstract void method3();

    private void method4() {
        System.out.println("倒出");
    }

    public boolean gouzi(){
        return true;
    }
}
