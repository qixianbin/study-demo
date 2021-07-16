package com.spring.study.designpatterns.factorypattern.factorymethod.factory;

import com.spring.study.designpatterns.factorypattern.factorymethod.pizza.IPizaa;

public interface IFactoryMethod {
    public IPizaa createPizza(String orderType);
}
