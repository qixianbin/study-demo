package com.spring.study.designpatterns.proxypattern.jdkproxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        SellTicks sellTicks = new TrainStation();
        ProxyFactory proxyFactory = new ProxyFactory(sellTicks);
        SellTicks proxyInstance = (SellTicks)proxyFactory.getProxyInstance();
        proxyInstance.sell();
    }
}
