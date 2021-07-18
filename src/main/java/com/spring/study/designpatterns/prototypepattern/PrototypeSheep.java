package com.spring.study.designpatterns.prototypepattern;

import java.io.*;

public class PrototypeSheep implements Cloneable,Serializable {

    int age;
    String name;
    PrototypeSheepFriend friend;

    public PrototypeSheep(int age, String name) {
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

    public PrototypeSheepFriend getFriend() {
        return friend;
    }

    public void setFriend(PrototypeSheepFriend friend) {
        this.friend = friend;
    }

    /**
     * 深拷贝方式1，clone
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected PrototypeSheep clone() throws CloneNotSupportedException {
        PrototypeSheep sheep = (PrototypeSheep)super.clone();
        sheep.friend = this.friend.clone();
        return sheep;
    }

    /**
     * 深拷贝方式2，序列化
     * @return
     */
    public PrototypeSheep deepCopy() throws IOException {

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            PrototypeSheep res = (PrototypeSheep) ois.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bos.close();
            oos.close();
            bis.close();
            ois.close();
        }
    }

    @Override
    public String toString() {
        return "PrototypeSheep{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }
}
