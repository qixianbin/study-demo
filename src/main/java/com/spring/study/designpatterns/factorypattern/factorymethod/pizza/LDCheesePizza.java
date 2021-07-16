package com.spring.study.designpatterns.factorypattern.factorymethod.pizza;

public class LDCheesePizza implements IPizaa {
    @Override
    public void makePizza() {
        System.out.println("生产伦敦奶酪披萨");
    }
    
    @Override
    public void payPizza() {
        System.out.println("销售伦敦奶酪披萨");
    }
}
