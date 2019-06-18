package com.doing.in2019.in05.in23.WebSocket.hellosocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServer {

	public static void main(String[] args) throws Exception {
		
		// 定义一对线程组
		EventLoopGroup faterGroup = new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();
		
		try {
			/* 2.Netty服务器的创建，定义服务器启动类ServerBootstrap */
			ServerBootstrap server = new ServerBootstrap();
			server.group(faterGroup, childGroup)			// serverBootstrap.group() 			方法定义了两个线程组的功能
					.channel(NioServerSocketChannel.class)	// serverBootstrap.channel()		设置双向通道类型为nio
					.childHandler(new WebSocketServerInitialzer());	// 配置自定义的子处理器
			
			/* 3.启动server，设置启动端口号8088，启动方式为同步 */
			ChannelFuture channelFuture = server.bind(8088).sync();
			
			/* 4.监听关闭的channel，设置为同步方式 */
			channelFuture.channel().close().sync();
		} finally {
			faterGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}
}