package java_adv_2nd_homeword;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0;i < args.length; i++) 
			hm.put(args[i], hm.getOrDefault(args[i], 0)+1);
		Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();
		for(Map.Entry<String, Integer> entry;it.hasNext();) {
			entry = it.next();
			System.out.println(String.format("<%s>=<%d>", entry.getKey(), entry.getValue()));
		}
	}
}
