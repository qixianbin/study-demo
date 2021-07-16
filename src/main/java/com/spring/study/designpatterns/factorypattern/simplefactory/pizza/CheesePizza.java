package com.spring.study.designpatterns.factorypattern.simplefactory.pizza;

public class CheesePizza implements IPizaa {
    @Override
    public void createPizza() {
        System.out.println("生产奶酪披萨");
    }
    
    @Override
    public void payPizza() {
        System.out.println("销售奶酪披萨");
    }
}
