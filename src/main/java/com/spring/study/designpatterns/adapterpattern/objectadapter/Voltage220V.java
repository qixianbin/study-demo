package com.spring.study.designpatterns.adapterpattern.objectadapter;

public class Voltage220V {
    public int out220V(){
        int res = 220;
        System.out.println("输出220伏电压");
        return res;
    }
}
