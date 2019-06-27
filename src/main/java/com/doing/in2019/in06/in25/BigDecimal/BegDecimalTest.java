package com.doing.in2019.in06.in25.BigDecimal;

import java.math.BigDecimal;


public class BegDecimalTest {
	
	// 计算常量
	private static final BigDecimal YI_BAI_WAN = BigDecimal.valueOf(1000000);			// 100万
	private static final BigDecimal LESS_THAN_ONE_MILLION = BigDecimal.valueOf(0.0035);	// 100万以下（含），手续费率0.35%
	
	public static void main(String[] args) {
		// 乘法
		BigDecimal bdl = BigDecimal.valueOf(0.35);
		System.out.println(bdl.multiply(BigDecimal.valueOf(100)));
		// 除法
		bdl = BigDecimal.valueOf(0.35);
		System.out.println(bdl.divide(BigDecimal.valueOf(100)));
		
		// 比较compareTo()返回的结果是int类型，-1表示小于，0是等于，1是大于。
		BigDecimal bd2 = BigDecimal.valueOf(0.36);
		System.out.println(bdl.compareTo(bd2));
		
		// 使用常量计算
		BigDecimal money = BigDecimal.valueOf(7000);	// 穷的只有7k
		if(money.compareTo(YI_BAI_WAN) < 0) {			// 铁定少于100万
			System.out.println(LESS_THAN_ONE_MILLION);	// 于是被收了0.35%的手续费
		}
	}
}
