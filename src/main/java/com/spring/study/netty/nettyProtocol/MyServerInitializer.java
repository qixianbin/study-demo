package com.spring.study.netty.nettyProtocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/24 0:13
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //加入解码器(接收客户端消息时调用)
        pipeline.addLast(new MyMessageDecoder());
        //加入编码器（给客户端回复消息时调用）
        pipeline.addLast(new MyMessageEncoder());
        //加入业务处理器
        pipeline.addLast(new MyServerHandler());
    }
}
