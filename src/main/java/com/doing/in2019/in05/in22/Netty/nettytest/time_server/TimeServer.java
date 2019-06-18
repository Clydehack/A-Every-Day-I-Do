package com.doing.in2019.in05.in22.Netty.nettytest.time_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
	
	
	public void bind (int port) throws Exception {
		
		// 创建俩组线程
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			
			// 创建一个服务器，设置监听port端口
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.childHandler(new ChildChannelHandler());
			ChannelFuture f = b.bind(port).sync();
			
			// 关闭
			f.channel().closeFuture().sync();
			
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	/* 绑定自定义的助手类 */
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			arg0.pipeline().addLast(new TimeServerHandler());
			/*
			 * 代码:
			 * 		arg0.pipeline().addLast("HttpServerCodec", new HttpServerCodec()).addLast(new TimeServerHandler());
			 * 访问:
			 * 		http://localhost:8080/msg=sdfsff
			 * 打印:
			 * 		15:38:43.377 [nioEventLoopGroup-3-3] DEBUG io.netty.channel.DefaultChannelPipeline - xxx
			 */
			
			/*
			 * 代码:
			 * 		arg0.pipeline().addLast(new TimeServerHandler());
			 * 访问:
			 * 		http://localhost:8080/msg=sdfsff
			 * 打印:
			 * 		15:38:43.377 [nioEventLoopGroup-3-3] DEBUG io.netty.channel.DefaultChannelPipeline - Discarded inbound message PooledUnsafeDirectByteBuf(ridx: 0, widx: 456, cap: 1024) that reached at the tail of the pipeline. Please check your pipeline configuration.
			 */
		}
	}
	
	/* 测试 */
	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				
				port = Integer.valueOf(args[0]);
				
			} catch (Exception e) {
				
			}
		}
		new TimeServer().bind(port);
	}
}
