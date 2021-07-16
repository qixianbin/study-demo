package com.spring.study.designpatterns.factorypattern.abstractfactory.product;

public class SanxingPC implements IPC {
    @Override
    public void makePC() {
        System.out.println("生产三星电脑");
    }
}
