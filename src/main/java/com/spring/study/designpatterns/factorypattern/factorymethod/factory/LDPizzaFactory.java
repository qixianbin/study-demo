package com.spring.study.designpatterns.factorypattern.factorymethod.factory;

import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.BJCheesePizza;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.IPizaa;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.LDCheesePizza;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.LDGreekPizza;
import com.spring.study.designpatterns.factorypattern.simplefactory.pizza.CheesePizza;

public class LDPizzaFactory implements IFactoryMethod {
    @Override
    public IPizaa createPizza(String orderType) {
        if("greek".equals(orderType)){
            return new LDGreekPizza();
        }else if("cheese".equals(orderType)){
            return new LDCheesePizza();
        }
        return null;
    }
}
