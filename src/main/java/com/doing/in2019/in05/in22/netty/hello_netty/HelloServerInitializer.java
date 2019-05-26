package com.doing.in2019.in05.in22.netty.hello_netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器,channel注册后，会执行里面的相应的初始化方法
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		// 通过SocketChannel获得对应的管道
		ChannelPipeline pipeline = channel.pipeline();
		// 通过管道添加handler，pipeline.add()把handler添加到哪个位置，一般是last
		// HttpServerCodec是netty提供的助手类，可以理解为拦截器
		// 当请求到服务端，我们需要做解码，响应到客户端做编码
		pipeline.addLast("HttpServerCodec", new HttpServerCodec());
		
		// 添加自定义的助手类，返回hello netty字符串
		pipeline.addLast("CustomHandler", new CustomHandler());
	}

}
