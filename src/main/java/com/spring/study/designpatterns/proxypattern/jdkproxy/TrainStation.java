package com.spring.study.designpatterns.proxypattern.jdkproxy;

public class TrainStation implements SellTicks {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
