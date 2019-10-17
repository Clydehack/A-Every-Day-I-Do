package com.doing.in2019.in05.in22.Netty.hello_netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

/**
 * 自定义的助手类(处理类，主要用于读取用户消息，并对用户消息进行处理，处理完毕后再发给相应的客户端)
 * 		SimpleChannelInboundHandler对于请求来说，相当于入站，入境
 */
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {

	/** channelRead0()  从缓冲区里读取数据 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		// 获取管道channel
		Channel channel = ctx.channel();
		
		// RequestMapping 在这里可以做类似于路由
		
		// 如果是http请求才打印，if里面都是response，如果不进行if()判断，就会打印一堆日志
		if(msg instanceof HttpRequest) {
			// 显示客户端远程地址
			System.out.println(channel.remoteAddress());
			channel.getClass().getName();
			
			// 通过缓冲区(不是直接发送数据)，定义发送的数据信息(将数据拷贝到缓冲区里)，Unpooled.copiedBuffer() 深拷贝的方法
			ByteBuf connect = Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8);
			
			// 将数据发送到客户端，构建一个http response 	DefaultFullHttpResponse(版本号，状态码，响应内容)
			FullHttpResponse response = 
					new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, connect);
			
			/* 对response进行设置 */
			// set数据类型(text/plain - 文字类型  ，也可以返回图片)
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			// set数据长度(connect.readableBytes() - 返回长度，可点进去看一下源码说明 )
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH, connect.readableBytes());
			
			// 将response返回给客户端，write()只把数据写入缓冲区，writeAndFlush()写完缓冲区就刷新到客户端
			ctx.writeAndFlush(response);
		}
	}

	
	/****************** Netty生命周期方法 - begin ******************/
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel注册");
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel移除");
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel活跃");
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel不活跃，客户端与服务端断开连接");
		super.channelInactive(ctx);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel读取完毕");
		super.channelReadComplete(ctx);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		System.out.println("用户事件触发，被此方法捕获");
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel可写事件被更改");
		super.channelWritabilityChanged(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("捕获channel异常，发生异常就会触发此方法");
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("助手类添加");
		super.handlerAdded(ctx);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("助手类移除");
		super.handlerRemoved(ctx);
	}
	/****************** Netty生命周期方法 - end ******************/
}