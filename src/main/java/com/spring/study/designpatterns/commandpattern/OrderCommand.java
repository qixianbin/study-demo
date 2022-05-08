package com.spring.study.designpatterns.commandpattern;

public class OrderCommand implements Command {

    private Order order;
    private SeniorChef seniorChef;

    public OrderCommand(Order order,SeniorChef seniorChef){
        this.order = order;
        this.seniorChef = seniorChef;
    }

    @Override
    public void execute() {
        seniorChef.makeFood(order.name);
    }
}
