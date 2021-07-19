package com.spring.study.designpatterns.bridgepattern;

public class MACSystem extends AbstractSystem {

    protected MACSystem(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("mac操作系统");
        videoFile.decode(fileName);
    }
}
