package java_adv_2nd_exper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {
	static HashMap<String, Integer> counter = new HashMap<String, Integer>();
	public static void main(String[] args) {
		String bookPath = "E:\\了不起的盖茨比英文.txt";
		String content = null;
		try {
			content = readFromTxt(bookPath);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("文件读取失败");
		}
		
		
		String[] words = sortWords(content.toLowerCase());
		
		
		try {
			writeTxt("E:\\result.txt", words);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("文件写入失败");
		}
		
	}
	
	private static String[] sortWords(String content) {
		String[] words = content.split("(\n|\t| )+");
		for(int i = 0;i < words.length;++i) {
			if(counter.getOrDefault(words[i], 0)>0) {
				counter.put(words[i], counter.get(words[i] )+1);
			}else {
				counter.put(words[i], 1);
			}
		}
		words = counter.keySet().toArray(new String[0]);
		Arrays.sort(words, new SortFunc());
		return words;
	}
	
	private static String readFromTxt(String filename) throws Exception{
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			reader = new FileReader(filename);
			int readed = reader.read(chars);
			while(readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			System.out.println("文件读取成功");
			return buf.toString();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	private static void writeTxt(String filename, String[] words) throws Exception{
		FileWriter writer = new FileWriter(filename);
		BufferedWriter out2File = new BufferedWriter(writer);
		for(int i = 0;i < words.length;i++) {
			out2File.write(words[i] + " " + counter.get(words[i])+"\n");
		}
		out2File.close();
		System.out.println("文件写入成功");
	}
	
}
