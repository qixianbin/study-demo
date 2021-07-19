package com.spring.study.designpatterns.bridgepattern;

public class BridgeTest {
    public static void main(String[] args) {
        AbstractSystem windowsSystem = new WindowsSystem(new MP4File());
        windowsSystem.play("战狼");
    }
}
