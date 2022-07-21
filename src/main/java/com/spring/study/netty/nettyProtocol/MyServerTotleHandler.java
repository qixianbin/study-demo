package com.spring.study.netty.nettyProtocol;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xianbin.Qi
 * @description TODO
 * @date 2022/3/1617:30
 */
@ChannelHandler.Sharable
public class MyServerTotleHandler extends ChannelInboundHandlerAdapter {
    
    private AtomicInteger totle = new AtomicInteger();
    
    public MyServerTotleHandler() {
        /**
         *  每两秒统计一下连接数
         */
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("connections: " + totle.get());
            
        }, 0, 2, TimeUnit.SECONDS);
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        totle.incrementAndGet();
        InetSocketAddress socketAddress = (InetSocketAddress)ctx.channel().remoteAddress();
        System.out.printf("当前客户端端口%d，总连接数%d\n",socketAddress.getPort(),totle.get());
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    
    }
    
}
