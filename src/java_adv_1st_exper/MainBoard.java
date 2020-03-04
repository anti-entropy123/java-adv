package java_adv_1st_exper;

public abstract class MainBoard extends Component{
	private double speed;
	
	MainBoard(String n, double s, double p){
		super(n, p);
		speed = s;
	}
	
	double getSpeed() {
		return speed;
	}
	
	@Override
	public void work(){
		System.out.println("MainBoard work");
	}
	@Override
	public String detail() {
		return String.format(
				"%s mainboard, speed is %.2f MiB/s;", 
				getName(),
				getSpeed(),
				getPrice()
				);
	}
}
