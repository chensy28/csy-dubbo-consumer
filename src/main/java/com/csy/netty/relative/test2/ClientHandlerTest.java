package com.csy.netty.relative.test2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author chensy
 * @date 2019-05-23 09:20
 */
public class ClientHandlerTest extends ChannelInboundHandlerAdapter {
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelWritabilityChanged();
    }
}
