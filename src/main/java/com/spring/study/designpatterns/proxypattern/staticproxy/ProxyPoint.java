package com.spring.study.designpatterns.proxypattern.staticproxy;

public class ProxyPoint implements SellTicks {

    private TrainStation trainStation;

    @Override
    public void sell() {
        System.out.println("代理点增强...收取手续费");
        trainStation.sell();
        System.out.println("代理点售票");
    }

    public void setTrainStation(TrainStation trainStation) {
        this.trainStation = trainStation;
    }
}
