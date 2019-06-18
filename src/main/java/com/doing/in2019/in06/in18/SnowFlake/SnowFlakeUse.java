package com.doing.in2019.in06.in18.SnowFlake;

/**
 * 分布式ID的实现 -- 满足高并发需求
 * 		机器CPU4核，内存8G，客户端只是使用了一个Channel，压测的CPU也没有跑满100%，数量在85000-105000之间
 * 
 * 		首先要实现一个单例
 * 		（可研究一下Semapore信号量用于控制并发的处理数，防止并发请求过大时，服务器负载过重而崩溃）
 * 
 * 		其次考虑分布式集群的问题
 * 
 * 		实现个http同步阻塞的方式
 * 		再实现个netty同步非阻塞的方式
 */
public class SnowFlakeUse {

}
