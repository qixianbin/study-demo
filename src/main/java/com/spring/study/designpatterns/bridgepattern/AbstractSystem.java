package com.spring.study.designpatterns.bridgepattern;

public abstract class AbstractSystem {
    protected VideoFile videoFile;

    protected AbstractSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
