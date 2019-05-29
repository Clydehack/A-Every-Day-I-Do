package com.doing.in2019.in05.in22.netty.nettytest.time_client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
 
public class TimerClient {
	
    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TimerClientHandler());
                        }
                    });
            ChannelFuture f = b.connect(host, port).sync();
 
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
 
    public static void main(String[] args) {
        int port = 8080;
        try {
            new TimerClient().connect(port, "localhost");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	// 进行测试的时候可以通过Telnet进行，通过telnet发送数据给我们的server，然后看server得反应。
		}
	}
}