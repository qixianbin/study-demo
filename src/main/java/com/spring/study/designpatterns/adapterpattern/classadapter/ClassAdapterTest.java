package com.spring.study.designpatterns.adapterpattern.classadapter;

public class ClassAdapterTest {
    public static void main(String[] args) {
        VoltageAdapter voltageAdapter = new VoltageAdapter();
        voltageAdapter.out5V();
    }
}
