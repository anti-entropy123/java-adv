package java_adv_2nd_exper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Arrays;


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
		for(int i = 0;i < words.length;i++) {
			System.out.println(words[i] + " " + counter.get(words[i]));
		}
		
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
	
}
