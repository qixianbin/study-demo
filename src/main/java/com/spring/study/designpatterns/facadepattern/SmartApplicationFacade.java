package com.spring.study.designpatterns.facadepattern;

public class SmartApplicationFacade {

    private Light light;
    private TV tv;

    public SmartApplicationFacade(){
        light = new Light();
        tv = new TV();
    }

    public void on(){
        light.on();
        tv.on();
    }

    public void off(){
        light.off();
        tv.off();
    }
}
