package java_adv_1st_exper;

public class Computer implements Product{
	String name;
	CPU cpu;
	Disk disk;
	MainBoard mainboard;
	RAM ram;
	
	Computer(String n, CPU c, RAM r, Disk d, MainBoard mb){
		name = n;
		cpu = c;
		ram = r;
		disk = d;
		mainboard = mb;
	}
	
	@Override
	public void run() {
		System.out.println("Computer running:");
		cpu.work();
		ram.work();
		disk.work();
		mainboard.work();
	}
	@Override
	public String getDescription() {
		return "Computer '" + name + "' consists of " + 
				cpu.detail() + " " + 
				ram.detail() + " " +
				disk.detail() + " " +
				mainboard.detail();
	}
	@Override
	public void showDescription() {
		System.out.println("Computer '" + name + "' consists of");
		System.out.println(cpu.detail());
		System.out.println(ram.detail());
		System.out.println(disk.detail());
		System.out.println(mainboard.detail()+"\n");
	}
	@Override
	public double getPrice() {
		return (double)(cpu.getPrice()+disk.getPrice()+mainboard.getPrice()+ram.getPrice());
	}
	@Override
	public void showPrice() {
		System.out.print("the price of computer '" + name + "' is ");
		System.out.println((double)(cpu.getPrice()+disk.getPrice()+mainboard.getPrice()+ram.getPrice())+" RMB\n");
	}
}
