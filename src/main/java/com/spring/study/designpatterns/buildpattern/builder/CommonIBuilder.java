package com.spring.study.designpatterns.buildpattern.builder;

import com.spring.study.designpatterns.buildpattern.product.House;

public class CommonIBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
        house.setBasic("5米地基");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子砌墙10厘米");
        house.setWall("10cm墙");
    }

    @Override
    public House build() {
        return house;
    }
}
