package com.spring.study.netty.nettyProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/23 22:58
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        //msg是二进制，直接输出不容易识别
//        System.out.println("Server 读取消息msg:" + msg);
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String s = new String(bytes, Charset.forName("utf-8"));
        System.out.println("Server 读取消息:" + s + "，服务器端处理次数：" + (++count));

        //给客户端回复消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务器端读取完成",Charset.forName("utf-8")));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server 服务端读完成");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server 客户端断开连接");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server 有客户端请求连接");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server 客户端请求连接成功");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Server exception");
        cause.printStackTrace();
        ctx.close();
    }
    
    
}
