package com.spring.study.designpatterns.proxypattern.staticproxy;

/**
 * 静态代理
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        TrainStation trainStation = new TrainStation();
        //创建代理对象
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.setTrainStation(trainStation);
        //执行代理对象的方法
        proxyPoint.sell();
    }
}
