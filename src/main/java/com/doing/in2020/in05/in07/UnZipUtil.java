package com.doing.in2020.in05.in07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class UnZipUtil {

	static final int BUFFER = 2048;

	public static void main(String[] args) throws IOException {
//		String zipName = "E://TestZip//zip.zip";
//		String[] pathNames = new String[] { "E://TestZip//zip1", "E://TestZip//zip2" };
		UnZipUtil test = new UnZipUtil(); 
//		test.zipFile(pathNames, zipName);
		test.unzipFile("I:\\新建文件夹 (3)","E:\\新建文件夹\\3638155657244430.zip");
		System.out.println("OK ");
	}

	public boolean zipFile(String[] pathNames, String zipName) {
		try {
			if (null != zipName && zipName.trim().equals(""))
				return false;
			if (null != pathNames && pathNames.length == 0)
				return false;

			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(zipName));
			ZipOutputStream out = new ZipOutputStream(bos);
			for (int i = 0; i < pathNames.length; i++) {
				File zipFile = new File(pathNames[i]);
				readFile(zipFile, out, zipFile.getName());
			}
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("resource")
	public boolean unzipFile(String filePath, String zipFilePath) {
		BufferedOutputStream outputStream = null;
		BufferedInputStream inputStream = null;
		try {
			ZipEntry zipEntry = null;
			ZipFile zipFile = null;
			zipFile = new ZipFile(zipFilePath);
			@SuppressWarnings("rawtypes")
			Enumeration enu = zipFile.entries();
			while (enu.hasMoreElements()) {
				zipEntry = (ZipEntry) enu.nextElement();
				if (zipEntry.isDirectory()) {
					new File(filePath + zipEntry.getName()).mkdirs(); 
					continue;
				}
				inputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
				int count;
				int BUFFER = 2048;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new FileOutputStream(filePath + zipEntry.getName());
				outputStream = new BufferedOutputStream(fos, BUFFER);
				while ((count = inputStream.read(data, 0, BUFFER)) != -1) {
					outputStream.write(data, 0, count);
				}
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	private void readFile(File file, ZipOutputStream out, String base) throws IOException {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < files.length; i++) {
				File tempFile = files[i];
				readFile(tempFile, out, base + tempFile.getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			byte[] data = new byte[BUFFER];
			FileInputStream inputStream = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(inputStream, BUFFER);
			int count;
			while ((count = buffer.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			buffer.close();
		}
	}
}