package com.doing.in2019.in06.in25.BigDecimal;

public class ReadMe {

	/**
	 * BegDecimal -- 关于money的姿势
	 * 
	 * 		双精度浮点型变量double可以处理16位有效数，float和double只能用来做科学计算或者是工程计算。
	 * 		在实际应用中，需要对更大或者更小的数进行运算和处理，Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。
	 * 		※ 在商业计算中要用java.math.BigDecimal ※
	 * 
	 * 		（不建议采用）BigDecimal(double) 创建一个具有参数所指定双精度值的对象。
	 * 		有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），
	 * 		但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。
	 * 		这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
	 * 		当double必须用作BigDecimal的源时，请使用Double.toString(double)转成String，然后使用String构造方法，
	 * 		或使用BigDecimal的静态方法valueOf
	 * 
	 * 		另一方面，String 构造方法是完全可预知的：写入 newBigDecimal("0.1") 将创建一个 BigDecimal，它正好等于预期的 0.1。
	 * 		因此，比较而言，通常建议优先使用String构造方法。
	 */
}