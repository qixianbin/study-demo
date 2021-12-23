package com.spring.study.netty.nettyProtocol;

import com.spring.study.netty.nettyProtocol.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @Description TODO 服务器自定义解码器，解决沾包拆包问题
 * @Author Qi
 * @Date 2021/12/24 0:29
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder 解码被调用");
        //将二进制字节码转成 MessageProtocol
        int len = in.readInt();
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        //封装成对象放入out
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(len);
        messageProtocol.setContent(bytes);

        out.add(messageProtocol);
    }
}
