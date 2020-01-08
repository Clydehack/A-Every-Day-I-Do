package com.doing.in2020.in01.in01.Algorithm;

public class ReadMe {

	/**
	 * Algorithm -- 算法1
	 * 
	 * 		①分析手上有哪些资源：
	 * 			共100数字，标记为n
	 * 			计算的结果，标记为sum
	 * 		
	 * 		②循环累加：
	 * 			100个数字依次相加需要99次，标记为i
	 * 
	 * 		③高斯求和
	 * 			先首尾相加，获得同一个值，再乘以50，标记为f
	 */

	/** 循环累加 */
	public static void mauthPlus() {
		int i, sum = 0, n = 100;
		for (i = 1; i < n; i++) {
			sum = sum + i;
		}
		System.out.println("1+2+3+...+100 循环累加结果为：" + sum);
	}

	/** 自己尝试高斯求和 */
	public static void MyMauth() {
		int sum = 0, n = 100, f = n / 2;
		sum = (1 + n) * f;
		System.out.println("自己尝试高斯求和结果为：" + sum);
	}
	/** 高斯求和 */
	public static void mauth() {
		int sum = 0, n = 100;
		sum = (1 + n) * n / 2;
		System.out.println("高斯求和算法结果为：" + sum);
	}

	public static void main(String[] args) {
		mauthPlus();
		MyMauth();
		mauth();
	}
}