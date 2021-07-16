package com.spring.study.designpatterns.factorypattern.factorymethod.pizza;

public class LDGreekPizza implements IPizaa {
    @Override
    public void makePizza() {
        System.out.println("生产伦敦希腊披萨");
    }
    
    @Override
    public void payPizza() {
        System.out.println("销售伦敦希腊披萨");
    }
}
