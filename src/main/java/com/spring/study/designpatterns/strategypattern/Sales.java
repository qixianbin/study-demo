package com.spring.study.designpatterns.strategypattern;

public class Sales {

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    private IStrategy strategy;

    public Sales(IStrategy strategy){
        this.strategy = strategy;
    }

    public void saleShow(){
        strategy.show();
    }
}
