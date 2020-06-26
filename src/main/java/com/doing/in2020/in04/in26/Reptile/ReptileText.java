package com.doing.in2020.in04.in26.Reptile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReptileText {

	private Queue<String> data = new LinkedList<String>();

	// 文章页面
	String PAGE = "https://zhuanlan.zhihu.com/p/65312096";

	Pattern p = Pattern.compile(PAGE);

	public void action(String target) throws IOException {

		Matcher m = p.matcher(target);

		// 如果是文章页面则读取
		if (m.find()) {

			URL url = new URL(target);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.connect();

			InputStream in = conn.getInputStream();

			byte[] buf = new byte[1024];

			int len = 0;

			// 分割url，把文章的编号作为文件的名字
			String[] bufen = target.split("/");

			String name = bufen[bufen.length - 1];

			name = name.replaceAll("html", "txt");

			File file = new File(name);

			FileOutputStream fp = new FileOutputStream(file);

			while ((len = in.read(buf)) != -1) {

				fp.write(buf, 0, len);

			}

			fp.close();

		}
		// 如果是列表页面
		// 抽取里面的文章页面连接
		else {

			URL url = new URL(target);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.connect();

			InputStream in = conn.getInputStream();

			byte[] buf = new byte[1024];

			// 把列表页的内容放到ByteArrayOutputStream中
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();

			int len = 0;

			while ((len = in.read(buf)) != -1) {
				// System.out.println(len);
				outStream.write(buf, 0, len);
			}
			in.close();
			outStream.close();

			String content = new String(outStream.toByteArray());

			Matcher page = p.matcher(content);

			// 抽取文章的url
			while (page.find()) {

				// 将抽取的文章url进队
				data.add(page.group());

			}

		}

	}

	public static void main(String args[]) throws IOException {

		ReptileText test = new ReptileText();

		// 起始页面
		String start = "http://xxx";

		test.data.add(start);

		// 列表页面
		String page = "http://xxx";

		// 总页数
		int total = 15;

		// 将15页列表页进队
		for (int i = 2; i <= total; i++)
			test.data.add(page + i);

		// 队列非空则一直爬取
		while (!test.data.isEmpty())
			test.action(test.data.poll());

	}
}