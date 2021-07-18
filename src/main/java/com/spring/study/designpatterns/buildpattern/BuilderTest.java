package com.spring.study.designpatterns.buildpattern;

import com.spring.study.designpatterns.buildpattern.builder.CommonIBuilder;
import com.spring.study.designpatterns.buildpattern.builder.HouseBuilder;
import com.spring.study.designpatterns.buildpattern.product.House;

public class BuilderTest {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector();
        HouseBuilder commonIBuilder = new CommonIBuilder();
        houseDirector.setHouseBuilder(commonIBuilder);
        House house = houseDirector.createHouse();
        System.out.println("流程"+house);

    }
}
