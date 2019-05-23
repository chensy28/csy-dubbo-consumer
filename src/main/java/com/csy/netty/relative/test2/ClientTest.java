package com.csy.netty.relative.test2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author chensy
 * @date 2019-05-23 09:20
 */
public class ClientTest {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8887;
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bs = new Bootstrap();
        bs.group(workGroup).channel(NioSocketChannel.class)
                .handler(new ClientHandlerTest())
                .connect(host, port);
    }
}
