package com.spring.study.designpatterns.prototypepattern;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        PrototypeSheep sheep = new PrototypeSheep(5,"xiaoyang");
        PrototypeSheepFriend friend = new PrototypeSheepFriend(5,"friend");
        sheep.setFriend(friend);
//        PrototypeSheep sheep1 = sheep.clone();
        PrototypeSheep sheep1 = sheep.deepCopy();
        PrototypeSheep sheep2 = sheep;
    
//        System.out.println("sheep:" + sheep.toString());
//        System.out.println("sheep2:" + sheep2.toString());
//        System.out.println("sheep == sheep2:" + (sheep == sheep2));
//
//        sheep.setName("dayang");
//        sheep.getFriend().setName("friend2");
//
//        System.out.println("sheep:" + sheep.toString());
//        System.out.println("sheep2:" + sheep2.toString());
//        System.out.println("sheep == sheep2:" + (sheep == sheep2));

        System.out.println("sheep:" + sheep.toString());
        System.out.println("sheep1:" + sheep1.toString());
        System.out.println("sheep == sheep1:" + (sheep == sheep1));

        sheep.setName("dayang");
        sheep.getFriend().setName("friend2");

        System.out.println("sheep:" + sheep.toString());
        System.out.println("sheep1:" + sheep1.toString());
        System.out.println("sheep == sheep1:" + (sheep == sheep1));
        
//        List<PrototypeSheep> list = new ArrayList<>();
//        list.add(new PrototypeSheep(1,"ss"));
//        List<PrototypeSheep> list2 = list;
//        list2.add(new PrototypeSheep(3,"sss"));
//        System.out.println(list == list2);
//        list.stream().forEach(sheeppp -> System.out.println(sheeppp));
//        list2.stream().forEach(sheepp -> System.out.println(sheepp));
    }
}
