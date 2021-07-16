package com.spring.study.designpatterns.factorypattern.simplefactory.factory;

import com.spring.study.designpatterns.factorypattern.simplefactory.pizza.CheesePizza;
import com.spring.study.designpatterns.factorypattern.simplefactory.pizza.GreekPizza;
import com.spring.study.designpatterns.factorypattern.simplefactory.pizza.IPizaa;

/**
 * 通过一个工厂来生产同类（接口）产品的不同（实现）产品
 */
public class FactoryStatic {
    
    public static IPizaa getPizza(String orderType){
    
        IPizaa pizza = null;
        
        if(("greek").equals(orderType)){
            pizza = new GreekPizza();
        }else if(("cheese").equals(orderType)){
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
