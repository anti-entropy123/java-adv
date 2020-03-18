package java_adv_2nd_exper;
import java.util.Comparator;

public class SortFunc implements Comparator<String>{
	public int compare(String a, String b) {
//		if(Main.counter.get(a) > Main.counter.get(b)) {
//			return -1;
//		}else if(Main.counter.get(a) == Main.counter.get(b)) {
//			return 0;
//		}else {
//			return 1;
//		}
		return -Main.counter.get(a).compareTo(Main.counter.get(b));
	}
}
