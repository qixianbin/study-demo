package com.spring.study.designpatterns.buildpattern.builder;

import com.spring.study.designpatterns.buildpattern.product.House;

public abstract class HouseBuilder {
    House house = new House();

    public abstract void buildBasic();
    public abstract void buildWall();
    public abstract House build();
}
