package com.doing.in2020.in04.in26.Reptile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 通过HTML解析实现图片批量下载
 * 
 * @author DorraChen
 * @version v1.0
 * @date 2017年10月22日 上午11:36:55
 */
public class Reptile {
	/**
	 * 第一步：获取页面的源代码； 第二步：解析源代码，含有图片的标签，再找到图片标签里面的src； 第三步：利用Java里面的net包，网络编程
	 */

	/**
	 * 根据网页和编码获取网页内容和源代码
	 * 
	 * @param url
	 * @param encoding
	 */
	public static String getHtmlResourceByUrl(String url, String encoding) {
		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader in = null;
		BufferedReader reader = null;

		try {
			// 建立网络连接
			urlObj = new URL(url);
			// 打开网络连接
			uc = urlObj.openConnection();
			uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 创建输入流
			in = new InputStreamReader(uc.getInputStream(), encoding);
			// 创建一个缓冲写入流
			reader = new BufferedReader(in);

			String line = null;
			while ((line = reader.readLine()) != null) {
				// 一行一行追加
				buffer.append(line + "\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	/**
	 * 根据图片的URL下载的图片到本地的filePath
	 * 
	 * @param filePath 文件夹
	 * @param imageUrl 图片的网址
	 */
	public static void downImages(String filePath, String imageUrl) {
		// 截取图片的名称
		String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));

		// 创建文件的目录结构
		File files = new File(filePath);
		if (!files.exists()) {// 判断文件夹是否存在，如果不存在就创建一个文件夹
			files.mkdirs();
		}
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			InputStream is = connection.getInputStream();
			// 创建文件
			File file = new File(filePath + fileName);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			is.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static class DownElement{
		String url;
		String filePath;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
	}
	public static List<DownElement> getElement() {
		List<DownElement> list = new ArrayList<Reptile.DownElement>();
		DownElement de = new DownElement();
		de.setFilePath("E:\\存这里");
		de.setUrl("https://xxx.com/xxx/");
		if(null != de) {
			list.add(de);
		}
		return list;
	}
	public static void downFile(String url, String filePath, String encoding) {
		String htmlResource = getHtmlResourceByUrl(url, encoding);
		// System.out.println(htmlResource);
		// 解析网页源代码
		Document document = Jsoup.parse(htmlResource);
		// 获取所有图片的地址
//        Elements elements = document.getElementsByTag("img");
//        Elements elements = document.getElementsByTag("a");
		Elements elements = document.getElementsByClass("rgg-simplelightbox size-medium rgg-img");

		for (Element element : elements) {
//        	String imgSrc = element.attr("src");
			String imgSrc = element.attr("href");
//        	if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
//        		// 判断imgSrc是否为空且是否以"http://"开头
//        		System.out.println("正在下载的图片的地址：" + imgSrc);
//        		downImages(filePath, imgSrc);
//        	}
			if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
				// 判断imgSrc是否为空且是否以"http://"开头
				System.out.println("正在下载的图片的地址：" + imgSrc);
				downImages(filePath, imgSrc);
			}
		}
		System.out.println("-------------------------下载完毕！----------------------------");
	}
	
	// 执行测试程序代码
	public static void main(String[] args) {
		List<DownElement> list = getElement();
		String encoding = "utf-8";
		if(list.size() > 0) {
			for (DownElement de : list) {
				downFile(de.getUrl(), de.getFilePath(), encoding);
			}
		}
	}
}
