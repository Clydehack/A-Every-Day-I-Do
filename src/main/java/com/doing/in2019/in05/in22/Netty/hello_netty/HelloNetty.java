package com.doing.in2019.in05.in22.Netty.hello_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 功能：实现客户端发送一个请求，服务器会返回hello netty
 */
public class HelloNetty {

	public static void main(String[] args) throws Exception {
		
		/* 1.定义一对线程组，当一些客户端连接到服务端后，允许channel进行注册，注册完后获得一些客户端的channels，然后直接丢给后面的从线程组去处理 */
		EventLoopGroup faterGroup = new NioEventLoopGroup();	// 主线程组，用于接受客户端的连接，但是不做任何处理
		EventLoopGroup childGroup = new NioEventLoopGroup();	// 从线程组，从线程组进行处理
		
		try {
			/* 2.Netty服务器的创建，定义服务器启动类ServerBootstrap */
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(faterGroup, childGroup)				// serverBootstrap.group() 			方法定义了两个线程组的功能
							.channel(NioServerSocketChannel.class)		// serverBootstrap.channel()		设置双向通道类型为nio
							.childHandler(new HelloServerInitializer());// serverBootstrap.childHandler()	子处理器，用于处理childGroup(从线程池的助手类初始化器)
			
			/* 3.启动server，设置启动端口号8088，启动方式为同步 */
			ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
			
			/* 4.监听关闭的channel，设置为同步方式 */
			channelFuture.channel().close().sync();
		} finally {
			faterGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}
}
