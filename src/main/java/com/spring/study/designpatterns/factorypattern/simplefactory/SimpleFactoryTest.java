package com.spring.study.designpatterns.factorypattern.simplefactory;

import com.spring.study.designpatterns.factorypattern.simplefactory.factory.FactoryStatic;
import com.spring.study.designpatterns.factorypattern.simplefactory.pizza.IPizaa;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        IPizaa pizza = FactoryStatic.getPizza("sdfsdf");
        if(pizza != null){
            pizza.createPizza();
            pizza.payPizza();
        }else{
            System.out.println("pizz参数不合法，无法生产对应的pizza");
        }
    }
}
