package com.spring.study.designpatterns.bridgepattern;

public class MP4File implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("mp4文件：" + fileName);
    }
}
