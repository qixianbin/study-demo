package com.spring.study.netty.nettyProtocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Description TODO 通过自定义协议解决沾包、拆包问题
 * @Author Qi
 * @Date 2021/12/24 0:17
 */
public class MyClientProtocolHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //连续发送多次
        for (int i = 0; i < 10; i++) {

            MessageProtocol msg = new MessageProtocol();

            msg.setContent("hello,我是客户端".getBytes(Charset.forName("utf-8")));
            msg.setLen("hello,我是客户端".getBytes(Charset.forName("utf-8")).length);

            //发送对象，需要进行编码处理
            ctx.writeAndFlush(msg);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("客户端接收到消息：len：" + len + "，content：" + new String(content,"UTF-8") + ",count：" + (++count));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
