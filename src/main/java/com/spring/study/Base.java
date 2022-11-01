package com.spring.study;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2022/5/29 19:15
 */
public class Base {
    public void methodOne(){
        System.out.println("A");
        methodTwo();
    }

    public void methodTwo(){
        System.out.println("B");
    }
}

class Driver extends Base{

    @Override
    public void methodOne(){
        super.methodOne();
        System.out.println("C");
    }

    @Override
    public void methodTwo(){
        super.methodTwo();
        System.out.println("D");
    }
}


