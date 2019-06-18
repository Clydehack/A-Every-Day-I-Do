package com.doing.in2019.in06.in13.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

/**
 * 解析使用竖线分隔的文件（竖线分隔符又称制表符分隔符）
 * 1.文件只放了路径忘记放文件名了，报错--java.io.FileNotFoundException: E:\readExcel\test (拒绝访问。)
 * 2.
 */
public class AnalysisVerticalLineFile {

	public static void main(String[] args) throws Exception {
		/*String str = simpleReadFile();
		analysisFile(str);*/
		System.out.println(LocalDate.now().minusDays(+1).toString());
	}

	/**
	 * 读取本地文件
	 */
	public static String simpleReadFile() {
		String str = ""; // 用于临时存放读取到的数据
		try {
			File file = new File("E:\\test case\\2019-06-10.txt");
			if (file.exists()) { // exists() 如果文件存在
				FileInputStream fis = new FileInputStream(file); // 获取文件输入流，字节流
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // 字符流，字节流转成字符流时要加编码格式，不然出现乱码
				BufferedReader br = new BufferedReader(isr); // 带缓冲区的reader
				String line; // 用于临时存放读取到的数据
				while ((line = br.readLine()) != null) { // 如果readLine不为空，说明文件还未结束，循环读取直到读完文件
					System.out.println(line);
					str = str + "\r\n" + line;
				}
				br.close();
				isr.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 读取http文件
	 */
	public static String GetHttpFile(String str) throws Exception {
		// 拉取http上的账单文件
		URL url = new URL(
				"http://116.228.64.55:9093/IMEServer/docroot/attachments/merchantCheck/2019/06/100009001000_20190610_1_allinpay.txt");
		URLConnection connection = url.openConnection(); 	// openConnection()
		InputStream in = connection.getInputStream(); 		// getInputStream() 获取输入流
		InputStreamReader isr = new InputStreamReader(in); 	//
		BufferedReader br = new BufferedReader(isr); 		// 包装完成

		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) { 			// 如果readLine()还在读取数据
			sb.append(line); 								// 将数据添加到sb
		}
		br.close();
		isr.close();
		in.close();
		return sb.toString();
	}

	/**
	 * 解析制表分隔符
	 */
	public static void analysisFile() {
		// List<String> Arrays = new ArrayList<String>();
		String str = "a|b";
		String[] strs = str.split("[|]");
		System.out.println(strs.length);
		if (strs.length > 0) {
			for (String s : strs) {
				System.out.println("===:" + s);
			}
		}
		// System.out.println(Arrays.asList(str.split("[|]")));
	}

	/**
	 * 解析制表分隔符
	 */
	public static void analysisFile(String str) {
		if ("".equals(str)) {
			return;
		}
		// List<String> Arrays = new ArrayList<String>();
		String[] strs = str.split("[|]", -1);
		System.out.println(strs.length);
		if (strs.length > 0) {
			for (String s : strs) {
				if ("".equals(s) || null == s) {
					s = "null";
				}
				System.out.println("===:" + s);
			}
		}
		// System.out.println(Arrays.asList(str.split("[|]")));
	}
}
