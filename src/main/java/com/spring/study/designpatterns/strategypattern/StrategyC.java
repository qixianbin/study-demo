package com.spring.study.designpatterns.strategypattern;

public class StrategyC implements IStrategy {
    @Override
    public void show() {
        System.out.println("满100减99");
    }
}
