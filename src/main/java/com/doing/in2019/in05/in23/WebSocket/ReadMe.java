package com.doing.in2019.in05.in23.WebSocket;

public class ReadMe {

	/**
	 *  仿微信的实时通信IM(Instant Messaging)
	 * 		MUI + H5PLUS			（移动端）
	 * 		SpringBoot2 + Netty4	（后端）
	 * 		MySQL5.6/MariaDB		（持久层）
	 * 		Nginx + FastDFS			（高性能分布式图片服务器）
	 * 		普通接口使用Restful
	 * 		聊天收发使用WebSocket
	 * 		
	 * 	传统APP开发最基本要两个移动端、一个后端、一个运维，So考虑使用跨平台实现
	 * 
	 * 	实时通信的技术
	 * 		Ajax轮询		（JS通过浏览器每隔一段（10s）时间访问服务器，是一种死循环，浏览器不用一直刷新，所以后台管理界面的数据显示一般用这种方法）
	 * 		Long pull	（类似Ajax，阻塞模型，直到服务端返回才释放）
	 * 		WebSocket	（基于http协议，持久化协议，例如游戏登陆后，一直在线的状态）
	 * 
	 * 		Http		1.0版本不支持长连接
	 * 					1.1版本支持keep-alive长连接
	 */
}