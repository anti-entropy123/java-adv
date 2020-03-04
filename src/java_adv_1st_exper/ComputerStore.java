package java_adv_1st_exper;

public class ComputerStore {
	Computer c1;
	Computer c2;
	Computer c3;
	
	ComputerStore(Computer a, Computer b, Computer c){
		c1 = a;
		c2 = b;
		c3 = c;
	}
	public void showProductTable() {
		System.out.println("Computer1:  " + c1.getDescription()+"  price is "+c1.getPrice()+ " RMB");
		System.out.println("Computer2:  " + c2.getDescription()+"  price is "+c2.getPrice()+ " RMB");
		System.out.println("Computer3:  " + c3.getDescription()+"  price is "+c3.getPrice()+ " RMB\n");
	}
}
