package com.spring.study.netty.nettyProtocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ExecutionException;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/23 23:07
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try{

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //加入自定义的编码器(给服务器端发送消息时调用)
                            pipeline.addLast(new MyMessageEncoder());
                            //加入解码器(接收服务端消息时调用)
                            pipeline.addLast(new MyMessageDecoder());
                            //加入自定义业务处理
//                            pipeline.addLast(new MyClientHandler());
                        }
                    });
            /*//同步方式启动
            ChannelFuture future = bootstrap.connect("localhost",8888).sync();
            System.out.println("客户端启动成功……");*/
            //异步方式启动，需要增加监听判断是否启动成功
//            ChannelFuture future = bootstrap.connect("localhost", 8888);
//            future.addListener(future1 -> {
//                if (!future1.isSuccess()) {
//                    System.out.println("客户端启动失败！！！！！");
//                    System.exit(0);
//                }
//            });
//            //阻塞当前
//            future.get();
            
            //测试单机能创建多少个连接
            while(!Thread.interrupted()){
                ChannelFuture future2 = bootstrap.connect("localhost", 8888);
                future2.addListener(future1 -> {
                    if (!future1.isSuccess()) {
                        System.out.println("客户端启动失败！！！！！");
                        System.exit(0);
                    }
                });
                //阻塞当前
                future2.get();
            }

//            future.channel().closeFuture().sync();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
