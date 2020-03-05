package java_adv_1st_homework;

import java.util.HashMap;

public class Singleton {
	static HashMap<String, Object> hm = new HashMap<String, Object>();
	//static Class<?> singletonable; 
	Singleton(String packageName, String[] className){
		try {
			//singletonable = Class.forName(packageName + ".Singletonable");
			for(int i = 0; i < className.length; i++) {
				Class<?> c = Class.forName(packageName + "." + className[i]);
				hm.put(className[i], c.newInstance());
			}
		}catch (Exception e) {
			System.out.println("反射失败");
		}
	}
	static public Object getInstance(String s) {
		return hm.get(s);
	}
}
