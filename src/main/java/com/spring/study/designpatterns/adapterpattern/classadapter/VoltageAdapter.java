package com.spring.study.designpatterns.adapterpattern.classadapter;

public class VoltageAdapter extends Voltage220V implements Ivoltage5V {

    @Override
    public int out5V() {
        int resouse = out220V();
        int res = resouse / 44;
        System.out.println("输出5伏电压");
        return res;
    }
}
