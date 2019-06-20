package com.doing.in2019.in06.in17.ChainOfResponsibility;

public class ReadMe {

	/**
	 * 责任链 -- 可以解决俗称if else地狱的方法 -- Netty的ChannelPipeline正是用的链式Handler！
	 * 
	 * 		问题示例：
	 * 			
	 * 			if(A,B,C,D,E,F){
	 * 				xxx;
	 * 			} else if {
	 * 				yyy;
	 * 			} else if {
	 * 				zzz;
	 * 			} .......  难以阅读，难以扩展
	 * 
	 * 
	 * 		代码优化后，结构变成这三个：
	 * 
	 * 			Context - 上下文类，就是将大量if else判断的入参封装成这一个类，或者叫Request类也没毛病
	 * 			Handler - 处理器类，一个handler可以看成是一个if{}判断块
	 * 			Control - 主控器类，持有大量的handler的方法
	 * 
	 * 
	 * 		原始流程说明：
	 * 			control主控器会先拿到一堆的if{}，然后当拿到一个context时（即原来的if判断需要一堆的参数），不进行判断处理直接挨个调用handler。
	 * 			handler里面判断是不是这个处理器处理，如果不是，返回告诉control主控器这不是我干的，然后主控器继续调用下一个handler，直到解决问题。
	 * 			这样就没有难以阅读，难以扩展的if else地狱了，不过实际上貌似也不好修改，待晚上有空了，提取一个之前的需求，实现一个demo测试一下看看。
	 * 		
	 * 		责任链流程说明：
	 * 			control管理一堆handler处理器也很累啊，要持有处理器列表，要负责任务转发，还要依赖每个Handler返回的标志决定该继续还是该中断等等，另类if else地狱  ( ﹁ ﹁ ) ~→
	 * 			何不让handler自己负责把控制往后发，这样control只要联系领头的handler就可以。这样每个handler可以自行决定是否要往后传递。
	 * 			而且还可以根据需要替换context的属性。
	 * 			总的来说感觉“责任链”还是要优于原始流程;
	 */
}