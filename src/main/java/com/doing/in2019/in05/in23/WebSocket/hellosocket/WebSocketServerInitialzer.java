package com.doing.in2019.in05.in23.WebSocket.hellosocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 子处理器
 */
public class WebSocketServerInitialzer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// 通过SocketChannel获得对应的管道
		ChannelPipeline pipeline = ch.pipeline();
		
		// add助手类
		
		// webSocket基于http协议，所以要有http编解码器
		pipeline.addLast(new HttpServerCodec());
		// 对写大数据流进行支持
		pipeline.addLast(new ChunkedWriteHandler());
		// 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse（HttpObjectAggregator是聚合器）
		// 几乎在netty中的编程，都会使用到此handler
		pipeline.addLast(new HttpObjectAggregator(1024*64));
		
		//--	以上是用于支持http协议		--//

		//--	以下是支持httpWebSocket	--//
		// webSocket服务器处理的协议，主要用于指定客户端访问路由，/ws一般代表webSocket(RequestMapping)
		// 这个handler会自己处理一些繁重的工作，比如握手，handShaking(close, ping, pong) ping + pong =心跳
		// 对于webSocket来说，都是以frames进行传输的，不同数据类型对应的frames也不同
		// WebSocketServerProtocolHandler webSocket协议助手类
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		
		// 自定义的handler
		pipeline.addLast(new ChatHandler());
	}
}