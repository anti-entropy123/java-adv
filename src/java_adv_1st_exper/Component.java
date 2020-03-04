package java_adv_1st_exper;

public abstract class Component {
	private String name;
	private double price;
	
	Component(String n, double p){
		name = n;
		price = p;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	abstract void work();
	abstract String detail();
}
