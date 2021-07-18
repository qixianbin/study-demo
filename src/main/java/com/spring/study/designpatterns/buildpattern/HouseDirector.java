package com.spring.study.designpatterns.buildpattern;

import com.spring.study.designpatterns.buildpattern.builder.HouseBuilder;
import com.spring.study.designpatterns.buildpattern.product.House;

public class HouseDirector {

    private HouseBuilder houseBuilder;

    public House createHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        return houseBuilder.build();
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
}
