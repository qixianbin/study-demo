package com.spring.study.designpatterns.bridgepattern;

public class WindowsSystem extends AbstractSystem {

    protected WindowsSystem(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("windows操作系统");
        videoFile.decode(fileName);
    }
}
