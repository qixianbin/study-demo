package com.spring.study.designpatterns.adapterpattern.interfaceadapter;

public class ClassAdapterTest {
    public static void main(String[] args) {
        VoltageAdapter voltageAdapter = new VoltageAdapter(new Voltage220V());
        voltageAdapter.out5V();
    }
}
