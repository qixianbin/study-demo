package com.spring.study.designpatterns.strategypattern;

public class StrategyB implements IStrategy {
    @Override
    public void show() {
        System.out.println("打2折");
    }
}
