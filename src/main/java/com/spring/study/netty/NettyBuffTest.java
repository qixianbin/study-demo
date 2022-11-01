package com.spring.study.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/27 23:30
 */
public class NettyBuffTest {
    public static void main(String[] args) {

        byte[] bytes = "abcdefg".getBytes();
        ByteBuf byteBuf = Unpooled.wrappedBuffer(bytes);
        ByteBuf byteBuf2 = Unpooled.copiedBuffer(bytes);
        System.out.println("wrappedBuffer=" + byteBuf.readByte());
        bytes[1] = " ".getBytes()[0];
        System.out.println("wrappedBuffer=" + byteBuf.readByte());
        System.out.println("copiedBuffer=" + byteBuf2.readByte());
        bytes[1] = " ".getBytes()[0];
        System.out.println("copiedBuffer=" + byteBuf2.readByte());
    }
}
