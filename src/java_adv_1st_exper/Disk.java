package java_adv_1st_exper;

public abstract class Disk extends Storage{
	Disk(String n, double v, double p){
		super(n, v, p);
	}
	
	@Override
	public void work() {
		System.out.println("Disk work");
	}
	@Override
	public String detail() {
		return String.format(
				"%s disk, volume is %.2f GiB;", 
				getName(),
				getVolume(),
				getPrice()
				);
	}
}
