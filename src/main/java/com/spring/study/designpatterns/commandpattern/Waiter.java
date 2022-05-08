package com.spring.study.designpatterns.commandpattern;

public class Waiter {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void doOrder(){
        command.execute();
    }
}
