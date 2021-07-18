package com.spring.study.designpatterns.proxypattern.cblibproxy;

public class CBLIBProxyTest {
    public static void main(String[] args) {
        TrainStation trainStation = new TrainStation();
        ProxyFactory factory = new ProxyFactory(trainStation);
        TrainStation proxyInstance = (TrainStation)factory.getProxyInstance();
        proxyInstance.sell();
    }
}
