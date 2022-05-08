package com.spring.study.designpatterns.commandpattern;

public class CommandTest {
    public static void main(String[] args) {
        Order order = new Order(1,"西红柿");
        SeniorChef seniorChef = new SeniorChef();
        Command orderCommand = new OrderCommand(order, seniorChef);
        Waiter waiter = new Waiter();
        waiter.setCommand(orderCommand);
        waiter.doOrder();
    }
}
