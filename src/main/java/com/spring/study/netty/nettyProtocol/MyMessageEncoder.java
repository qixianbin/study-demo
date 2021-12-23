package com.spring.study.netty.nettyProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description TODO 发送数据时进行编码
 * @Author Qi
 * @Date 2021/12/24 0:23
 */
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder 编码被调用");
        int len = msg.getLen();
        byte[] content = msg.getContent();

        out.writeInt(len);
        out.writeBytes(content);
    }
}
