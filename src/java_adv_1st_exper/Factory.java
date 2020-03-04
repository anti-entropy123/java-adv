package java_adv_1st_exper;

public class Factory{
	public static Component get(String p1, double p2, double p3) {
		Component result = null;
		switch(p1) {
		case "Intel":
			result = new Intel((int)p2, p3);
			break;
		case "AMD":
			result = new AMD((int)p2, p3);
			break;
		case "Samsung":
			result = new Samsung(p2,p3);
			break;
		case "Kingston":
			result = new Kingston(p2,p3);
			break;
		case "Seagate":
			result = new Seagate(p2,p3);
			break;
		case "WestDigitals":
			result = new WestDigitals(p2,p3);
			break;
		case "Asus":
			result = new Asus(p2,p3);
			break;
		case "Gigabyte":
			result = new Gigabyte(p2,p3);
			break;
		default:
			reportError();
		}
		return result;
	}
	private static void reportError() {
		System.out.println("parameter error");
	}
}
