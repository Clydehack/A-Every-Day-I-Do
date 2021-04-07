package com.doing.in2019.in07.in13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

	/**
	 * 寻找排好序的数组中的一个值
	 * 
	 * @param array 要查找的数组*
	 * @param value 查找的值*
	 * @param left  左边界，这个值必须位于数组长度区间内*
	 * @param right 右边界，这个值必须位于数组长度区间内*0 return 找到的值在数组中的位置，如果没找到就返回-1
	 */
	static int binarySearch(int[] array, int value, int left, int right) {
		if (left > right) // 退出条件
			return -1; // 没找到指定的元素
		int middle = (left + right) >>> 1; // 相当于 mid = (left+right) /2
		if (array[middle] == value)
			return middle; // 找到了
		else if (array[middle] > value)
			return binarySearch(array, value, left, middle - 1); // 递归调用查找左边
		else
			return binarySearch(array, value, middle + 1, right); // 递归调用查找右边
	}

	public static void main(String[] args) {
		int[] data = { 3, 4, 5, 6, 7 };
		// 调用 binarySearch 方法 ， 其中 left 的初始值是 0 ， right 的初始值是数组长度
		int ret = binarySearch(data, 6, 0, data.length);
		System.out.println(ret); // 输出 3

		// 要查找动态数组中已经排好序的元素 ， 可以直接调用 Collections.binarySearch 方法
	}

	/** 查找动态数组中已经排好序的元素 ， 可以直接调用 Collections.binarySearch 方法 */
	public void listBinarySearch() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 增加一些整数
		list.add(3);
		list.add(7);
		list.add(6);
		list.add(9);
		// 在调用 binarySearch () 方法之前 ， 先对集合中的元素排序
		Collections.sort(list);
		// 得到元素 2 所在的位置 ， 如果没有找到 ， 就返回一个负数
		int index = Collections.binarySearch(list, 2);
		if (index > 0) {
			System.out.println(" 找到的位置 ： " + index);
		}
	}

	/** 查找数组中已经排好序的元素 ， 可以直接调用 Arrays . binarySearch 方法 */
	public void arrayBinarySearch() {
		int[] ids = { 3, 7, 6, 9 }; // 待查找的数组
		Arrays.sort(ids);
		int index = Arrays.binarySearch(ids, 2);
		if (index > 0) {
			System.out.println(" 找到的位置 ： " + index);
		}
	}
}