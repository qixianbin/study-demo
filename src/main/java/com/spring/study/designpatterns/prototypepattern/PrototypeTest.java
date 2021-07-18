package com.spring.study.designpatterns.prototypepattern;

import java.io.IOException;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        PrototypeSheep sheep = new PrototypeSheep(5,"xiaoyang");
        PrototypeSheepFriend friend = new PrototypeSheepFriend(5,"friend");
        sheep.setFriend(friend);
//        PrototypeSheep sheep1 = sheep.clone();
        PrototypeSheep sheep1 = sheep.deepCopy();

        System.out.println("sheep:" + sheep.toString());
        System.out.println("sheep1:" + sheep1.toString());
        System.out.println("sheep == sheep1:" + (sheep == sheep1));

        sheep.setName("dayang");
        sheep.getFriend().setName("friend2");

        System.out.println("sheep:" + sheep.toString());
        System.out.println("sheep1:" + sheep1.toString());
        System.out.println("sheep == sheep1:" + (sheep == sheep1));
    }
}
