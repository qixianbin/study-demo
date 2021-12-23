package com.spring.study.netty.nettyProtocol;

/**
 * @Description TODO 自定义协议解决粘包、拆包问题
 * @Author Qi
 * @Date 2021/12/24 0:14
 */
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
