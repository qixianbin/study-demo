package com.spring.study.designpatterns.factorypattern.abstractfactory.product;

public class SanxingPhone implements IPhone {
    @Override
    public void makePhone() {
        System.out.println("生产三星手机");
    }
}
