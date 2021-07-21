package com.spring.study.designpatterns.facadepattern;

public class FacadeTest {
    public static void main(String[] args) {
        SmartApplicationFacade smartApplicationFacade = new SmartApplicationFacade();
        smartApplicationFacade.on();

        smartApplicationFacade.off();
    }
}
