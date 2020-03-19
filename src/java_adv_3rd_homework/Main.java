package java_adv_3rd_homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Main {
	public static void main(String[] args) {
		String source = "E:\\result.txt";
		String destination = "E:\\newresult.txt";
		File srcFile = new File(source);
		File destFile = new File(destination);
		if(srcFile.isFile()) {
			try {
				FileOutputStream out = new FileOutputStream(destFile);
				FileInputStream in = new FileInputStream(srcFile);
				int read = 0;
				byte[] cache = new byte[1024];
				while((read = in.read(cache)) != -1) {
					out.write(cache);
				}
				out.close();
				in.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.print("失败");
			}
		}else {
			System.out.println("路径错误");
		}
	}
}
