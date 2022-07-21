package com.spring.study.designpatterns.adapterpattern.interfaceadapter;

/**
 * @author xianbin.Qi
 * @description TODO
 * @date 2022/5/1111:25
 */
public abstract class AbsAdapter implements Ivoltage5V{
    
    @Override
    public int out5V() {
        return 0;
    }
    
    @Override
    public int out10V() {
        return 0;
    }
    
    @Override
    public int out20V() {
        return 0;
    }
}
