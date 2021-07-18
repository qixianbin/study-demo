package com.spring.study.designpatterns.prototypepattern;

import java.io.Serializable;

public class PrototypeSheepFriend implements Cloneable, Serializable {

    int age;
    String name;

    public PrototypeSheepFriend(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected PrototypeSheepFriend clone() throws CloneNotSupportedException {
        return (PrototypeSheepFriend)super.clone();
    }

    @Override
    public String toString() {
        return "PrototypeSheepFriend{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
