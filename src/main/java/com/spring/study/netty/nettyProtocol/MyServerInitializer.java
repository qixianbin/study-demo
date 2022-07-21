package com.spring.study.netty.nettyProtocol;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/24 0:13
 */
@ChannelHandler.Sharable
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    
    ChannelInboundHandlerAdapter handler;
    
    public MyServerInitializer(MyServerTotleHandler handler){
        this.handler = handler;
    }
    
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //加入解码器(接收客户端消息时调用)
        pipeline.addLast(new MyMessageDecoder());
        //加入编码器（给客户端回复消息时调用）
        pipeline.addLast(new MyMessageEncoder());
        //加入业务处理器
        pipeline.addLast(new MyServerHandler());
        //加入统计器，统计一共多少连接
        pipeline.addLast(handler);
    }
}
