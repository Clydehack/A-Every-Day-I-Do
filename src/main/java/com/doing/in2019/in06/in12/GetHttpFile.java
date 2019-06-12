package com.doing.in2019.in06.in12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetHttpFile {

	public static void main(String[] args) throws Exception {
		// 拉取http上的账单文件
		URL url = new URL("http://116.228.64.55:9093/IMEServer/docroot/attachments/merchantCheck/2019/06/100009001000_20190610_1_allinpay.txt");
		URLConnection connection = url.openConnection();	//openConnection()
		InputStream in = connection.getInputStream();		//getInputStream()	获取输入流
		InputStreamReader isr = new InputStreamReader(in);	//
		BufferedReader br = new BufferedReader(isr);		//包装完成
		
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {			//如果readLine()还在读取数据
			
			sb.append(line);								//将数据添加到sb
		}
		
		br.close();
		isr.close();
		in.close();
		
		System.out.println(sb.toString());
	}
}
