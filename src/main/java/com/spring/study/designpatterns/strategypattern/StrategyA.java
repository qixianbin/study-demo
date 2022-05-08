package com.spring.study.designpatterns.strategypattern;

public class StrategyA implements IStrategy {
    @Override
    public void show() {
        System.out.println("打一折");
    }
}
