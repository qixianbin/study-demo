package com.spring.study.designpatterns.strategypattern;

public class StrageTest {
    public static void main(String[] args) {
        Sales sales = new Sales(new StrategyA());
        sales.saleShow();

        sales.setStrategy(new StrategyB());
        sales.saleShow();

    }
}
