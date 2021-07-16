package com.spring.study.designpatterns.factorypattern.factorymethod.factory;

import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.BJCheesePizza;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.BJGreekPizza;
import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.IPizaa;

public class BJPizzaFactory implements IFactoryMethod {
    @Override
    public IPizaa createPizza(String orderType) {
        if("greek".equals(orderType)){
            return new BJGreekPizza();
        }else if("cheese".equals(orderType)){
            return new BJCheesePizza();
        }
        return null;
    }
}
