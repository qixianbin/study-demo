package com.spring.study.designpatterns.factorypattern.simplefactory.pizza;

public class GreekPizza implements IPizaa {
    @Override
    public void createPizza() {
        System.out.println("生产希腊披萨");
    }
    
    @Override
    public void payPizza() {
        System.out.println("销售希腊披萨");
    }
}
