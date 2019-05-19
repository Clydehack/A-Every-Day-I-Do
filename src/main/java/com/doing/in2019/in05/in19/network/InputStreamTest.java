package com.doing.in2019.in05.in19.network;

import java.io.InputStream;

/**
 * 输入流，用于读取数据，InputStream类提供了将数据读取为原始字节的基本方法，无论读取那种数据源，都使用这6各主要方法。
 * 
 * 主要方法：
 * 		read()（基本方法，从输入流的源中读取1字节数据，作为一个0-255的int返回，流的结束标志是-1，阻塞后续代码执行!基本方法效率不高，下面有两个重载方法提高效率）
 * 		read(byte[] input)（）
 * 		read(byte[] input, int offset, int length)（）
 * 		skip(long n)（）
 * 		available()（）
 * 		close()
 * 		（结束一个流操作后，关闭释放与这个流关联的所有资源，如果输出流已经关闭，继续写入时会抛出IOException异常）
 * 		（在java6以前版本，需要在finally中显式的关闭流；在java7以后，带资源的try可以自动调用close()方法，不过JavaMail是例外）
 * 
 * 		
 */
public class InputStreamTest {

	public static void main(String[] args) {
		//readBaseTest(in);
	}
	
	/**
	 * 例：
	 * 		使用基本read()方法实现
	 * 		从in中读取10字节数据，存储在byte数组input中，如果检测到流结束，就提前终止循环
	 * 		虽然read()只读取1字节， 但会返回一个无符号（0~255）int，这样把结果存储到字节数组前必须进行类型转换，要将有符号字节（-128~127）转换为无符号字节。
	 * 		从输入流的源中读取1字节数据(效率不高)
	 */
	public static void readBaseTest(InputStream in) throws Exception {
		byte[] input = new byte[10];
		for(int i = 0; i < input.length; i++) {
			int b = in.read();
			if(b == -1) {
				break;
			}
			input[i] = (byte)b;
		}
	}
}