package java_adv_1st_exper;

public abstract class CPU extends Component{
	private int coreNum;
	
	CPU(String n, int c, double p){
		super(n, p);
		coreNum = c;
	}
	
	public int getCoreNum() {
		return coreNum;
	}
	
	@Override
	public void work() {
		System.out.println("CPU work");
	}
	
	@Override
	public String detail() {
		return String.format(
				"%s cpu, coreNum is %d;", 
				getName(),
				getCoreNum(),
				getPrice()
				);
	}
}
