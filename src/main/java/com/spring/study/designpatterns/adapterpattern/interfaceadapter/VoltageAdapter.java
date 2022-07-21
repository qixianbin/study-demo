package com.spring.study.designpatterns.adapterpattern.interfaceadapter;

public class VoltageAdapter extends AbsAdapter {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int out5V() {
        int resouse = voltage220V.out220V();
        int res = resouse / 44;
        System.out.println("输出5伏电压");
        return res;
    }
}
