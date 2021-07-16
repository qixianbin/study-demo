package com.spring.study.designpatterns.factorypattern.factorymethod;

import com.spring.study.designpatterns.factorypattern.factorymethod.factory.BJPizzaFactory;
import com.spring.study.designpatterns.factorypattern.factorymethod.factory.IFactoryMethod;
import com.spring.study.designpatterns.factorypattern.factorymethod.factory.LDPizzaFactory;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.IPizaa;

public class FactoryMethodTest {
    public static void main(String[] args) {
        IFactoryMethod factoryMethod = new BJPizzaFactory();
        IFactoryMethod factoryMethod1 = new LDPizzaFactory();
    
        IPizaa pizza = factoryMethod.createPizza("cheese");
        IPizaa pizza1 = factoryMethod1.createPizza("greek");
        
        pizza.makePizza();
        
        pizza1.makePizza();
    }
}
