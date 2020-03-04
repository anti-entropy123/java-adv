package java_adv_1st_exper;

public abstract class RAM extends Storage{
	RAM(String n, double v, double p){
		super(n, v, p);
	}
	
	@Override 
	public void work() {
		System.out.println("RAM work");
	}
	@Override
	public String detail() {
		return String.format(
				"%s ram, volume is %.2f GiB;", 
				getName(),
				getVolume(),
				getPrice()
				);
	}
}
