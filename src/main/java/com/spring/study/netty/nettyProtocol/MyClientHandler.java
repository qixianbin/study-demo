package com.spring.study.netty.nettyProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/23 23:13
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        //msg是二进制，直接输出不容易识别
//        System.out.println("client 收到server返回的msg:" + msg);
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String s = new String(bytes, Charset.forName("utf-8"));
        System.out.println("client 读取消息转换:" + s + "；客户端收到消息次数：" + (++count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功");
//        ctx.writeAndFlush(Unpooled.wrappedBuffer("客户端请求连接".getBytes()));
        /*
         * @Author Qi
         * @Description //TODO 正常发送，此时会出现沾包问题
         * @Date 2021/12/24 0:01 
         * @Param [ctx]
         * @return void
        **/
        for (int i = 0; i < 10; i++) {
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello我是客户端" + i + "，", Charset.forName("utf-8"));
            ctx.writeAndFlush(byteBuf);
        }
    }
}
