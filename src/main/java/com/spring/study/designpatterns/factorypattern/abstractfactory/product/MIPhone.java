package com.spring.study.designpatterns.factorypattern.abstractfactory.product;

public class MIPhone implements IPhone {
    @Override
    public void makePhone() {
        System.out.println("生产小米手机");
    }
}
