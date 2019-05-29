package com.doing.in2019.in05.in23.websocket.hellosocket;

import java.time.LocalDateTime;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 对话处理程序
 * 		对客户端传过来的相应的消息，进行相应的处理，处理完后把相应的消息传给客户端
 * 		SimpleChannelInboundHandler对于请求来说，相当于入站，入境
 * 		TextWebSocketFrame，在netty中，是用于webSocket中专门处理文本类型的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	// 用于记录和管理所有客户端的channel
	private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

		// 获取管道channel，这个不用获得管道吗？？？
		//Channel channel = ctx.channel();
		
		// 获取客户端传输过来的文本类型数据
		String str = msg.text();
		//System.out.println("接收到：" + str);
		
		for (Channel channel : clients) {
			channel.writeAndFlush(new TextWebSocketFrame("服务器接收到：" + LocalDateTime.now() + "，消息：" + str));
		}
		/*
		 * 或同等方法：
		 * clients.writeAndFlush(new TextWebSocketFrame("服务器接收到：" + LocalDateTime.now() + "，消息：" + str));
		 */
		
	}

	// 用户连接，获取客户端的channel，并放到channelGroup中进行管理
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		clients.add(ctx.channel());
	}

	// 用户离开
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// 当触发handlerRemoved，channelGrouph会自动移除d对应客户端的channel
		clients.add(ctx.channel());
		System.out.println("用户离开，短id:" + ctx.channel().id().asShortText());
		System.out.println("用户离开，长id:" + ctx.channel().id().asLongText());
	}
}
