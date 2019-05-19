package com.doing.in2019.in05.in19.network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 输出流，用于写入数据
 * 
 * 主要方法：
 * 		write(int b)（基本方法，抽象方法，接受0-255之间的整数作为参数，将对应的字节写入到输出流中。基本方法效率不高，下面有两个重载方法提高效率）
 * 		write(byte[] data)（）
 * 		write(byte[] data, int offset, int length)（）
 * 		flush()（写完数据后，刷新输出流，可以强迫缓冲的流发送数据）
 * 		close()
 * 		（结束一个流操作后，关闭释放与这个流关联的所有资源，如果输出流已经关闭，继续写入时会抛出IOException异常）
 * 		（在java6以前版本，需要在finally中显式的关闭流；在java7以后，带资源的try可以自动调用close()方法，不过JavaMail是例外）
 */
public class OutputStreamTest {
	
	public static void main(String[] args) throws Exception {
		//generateCharacters();
	}
	
	/**
	 * 例：
	 * 		使用基本write()方法实现
	 * 		字符生成器协议（定义了一个发出ASCII文本）
	 * 		一次向out写入1字节(效率不高)
	 */
	public static void generateCharacter(OutputStream out) throws IOException {
		int firstPrintableCharacter = 33;		// 第一个可打印字符
		int numberOfPrintableCharacters = 94;	// 可打印字符数
		int numberOfCharactersPerLine = 72;		// 每一行的字符数
		
		int start = firstPrintableCharacter;
		while(true) {
			for(int i = start; i < start + numberOfCharactersPerLine; i++) {
				// write()方法接受一个int作为参数，但实际上会写入一个无符号字节，Java没有无符号字节这个数据类型！
				out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters)
						+ firstPrintableCharacter);
			}
			out.write('\r');					// 回车
			out.write('\n');					// 换行
			start = ((start + 1) - firstPrintableCharacter)
					% numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
	
	/**
	 * 例：
	 * 		使用 write(byte[] data) 或 write(byte[] data, int offset, int length)
	 * 		字符生成器协议（定义了一个发出ASCII文本）
	 * 		多字节一次全部发送(效率提高了)
	 */
	public static void generateCharacters(OutputStream out) throws IOException {
		int firstPrintableCharacter = 33;		// 第一个可打印字符
		int numberOfPrintableCharacters = 94;	// 可打印字符数
		int numberOfCharactersPerLine = 72;		// 每一行的字符数
		int start = firstPrintableCharacter;
		byte[] line = new byte[numberOfCharactersPerLine + 2];// +2对应回车和换行
		
		while(true) {
			for(int i = start; i < start + numberOfCharactersPerLine; i++) {
				line[i - start] = (byte)((i - firstPrintableCharacter)
						% numberOfPrintableCharacters + firstPrintableCharacter);
			}
			line[72] = (byte)'\r';
			line[73] = (byte)'\n';
			out.write(line);
			start = ((start + 1) - firstPrintableCharacter)
					% numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
	
	/**
	 * 例：
	 * 		使用 close()
	 * 		java6以前显式的关闭流
	 */
	public void testBeforeJava6() {
		OutputStream out = null;
		try {
			out = new FileOutputStream( "/tmp/data.txt" );
			// 处理输出流
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 为了避免 NullPointerException，关闭流之前要先检查流是否是 null
			if(out != null) {
				try {
					out.close();
				} catch (Exception e) {
					// 忽略关闭流时出现的异常，或只是把异常记录日志
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 例：
	 * 		使用 close()
	 * 		java7以后可以自动调用close，减少了很多代码；JavaMail Transport 是唯一的需要显式释放资源的对象。
	 */
	public void testJava7() {
		try (OutputStream out = new FileOutputStream( "/tmp/data.txt" ) ) {
			// 处理输出流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}