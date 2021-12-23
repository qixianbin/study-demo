package com.spring.study.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("直接打印服务端需要处理的信息: " + buf.toString(CharsetUtil.UTF_8));
        ByteBuf res = Unpooled.wrappedBuffer(new String("塔台收到!塔台收到!信息如下, 请确认 " + buf.toString(CharsetUtil.UTF_8)).getBytes());
        /**
         * 给客户端回复消息
         */
        ctx.writeAndFlush(res);
    }
    
    /**
     * 连接成功后，自动执行该方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务器首次处理!");
        /**
         * 这种发送的消息格式是错误的!!!!!
         * 消息格式必须是ByteBuf才行!!!!!
         */
        ctx.writeAndFlush(Unpooled.wrappedBuffer("Hello is server !".getBytes()));
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务器读完成");
        super.channelReadComplete(ctx);
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开连接");
        super.channelInactive(ctx);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        /**
         * 异常捕获
         */
        System.out.println("客户端关闭，异常");
        cause.printStackTrace();
        ctx.close();
    }
}
