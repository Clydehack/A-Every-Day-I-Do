package com.doing.in2019.in05.in22.netty.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
	
	public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
		
		// 读取输入流并打印
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order:" + body);
		
		// 生成输出流并发送（这是从哪抄的代码。。 只把数据扔缓冲区里了，没法给客户端。。。）
		String currentTime = 
			"QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
			ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
			ctx.write(resp);
	}
	
	public void channelReadComplete (ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
