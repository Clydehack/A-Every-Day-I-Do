package com.doing.in2019.in05.in23.websocket.hellosocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 对话处理程序
 * 		对客户端传过来的相应的消息，进行相应的处理，处理完后把相应的消息传给客户端
 * 		SimpleChannelInboundHandler对于请求来说，相当于入站，入境
 * 		TextWebSocketFrame，在netty中，是用于webSocket中专门处理文本类型的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

		// 获取管道channel，这个不用获得管道吗？？？
		//Channel channel = ctx.channel();
		
		// 获取客户端传输过来的文本类型数据
		String content = msg.text();
		
	}
}
