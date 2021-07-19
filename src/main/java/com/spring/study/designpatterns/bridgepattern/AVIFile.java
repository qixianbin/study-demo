package com.spring.study.designpatterns.bridgepattern;

public class AVIFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("avi文件：" + fileName);
    }
}
