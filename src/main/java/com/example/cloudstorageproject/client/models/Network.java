package com.example.cloudstorageproject.client.models;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


import io.netty.channel.socket.SocketChannel;

public class Network {
    private SocketChannel channel;
    public Network() {
        new Thread(() -> {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                Bootstrap b = new Bootstrap();
                b.group(workerGroup)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                channel = socketChannel;
                            }
                        });
                ChannelFuture future = b.connect("localhost", 8080).sync();
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
            }
        }).start();
    }

    public void beginAuth() {

    }
}
