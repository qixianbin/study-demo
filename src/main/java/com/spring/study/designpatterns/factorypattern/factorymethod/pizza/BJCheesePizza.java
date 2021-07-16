package com.spring.study.designpatterns.factorypattern.factorymethod.pizza;

public class BJCheesePizza implements IPizaa {
    @Override
    public void makePizza() {
        System.out.println("生产北京奶酪披萨");
    }
    
    @Override
    public void payPizza() {
        System.out.println("销售北京奶酪披萨");
    }
}
