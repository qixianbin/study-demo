package com.spring.study.designpatterns.factorypattern.abstractfactory.product;

public class MIPc implements IPC {
    @Override
    public void makePC() {
        System.out.println("生产小米电脑");
    }
}
