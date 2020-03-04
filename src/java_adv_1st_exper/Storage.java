package java_adv_1st_exper;

public abstract class Storage extends Component{
	private double volume;
	
	Storage(String n, double v, double p){
		super(n, p);
		volume = v;
	}
	
	double getVolume() {
		return volume;
	}
}
