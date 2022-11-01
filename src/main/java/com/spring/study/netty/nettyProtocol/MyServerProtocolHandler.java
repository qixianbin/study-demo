package com.spring.study.netty.nettyProtocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2021/12/24 0:16
 */
public class MyServerProtocolHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("服务端接收到信息：len："+len+",content:"+new String(content, Charset.forName("utf-8")));
        System.out.println("服务器端接收到消息次数" + (++count));

        //给客户端回复消息
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setContent("服务器端读取完成".getBytes(StandardCharsets.UTF_8));
        messageProtocol.setLen("服务器端读取完成".getBytes(StandardCharsets.UTF_8).length);

//        ctx.writeAndFlush(messageProtocol);
        ctx.write(messageProtocol);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端读完成");
        ctx.flush();
    }
}
