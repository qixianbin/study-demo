package com.spring.study.designpatterns.templatemethodpattern;

public class DouJiang extends AbstractClass {
    @Override
    public void method2() {
        System.out.println("打豆子");
    }

    @Override
    public void method3() {
        System.out.println("加水研磨");
    }

    /**
     * 重写钩子方法
     * @return
     */
    @Override
    public boolean gouzi() {
        return false;
    }
}
