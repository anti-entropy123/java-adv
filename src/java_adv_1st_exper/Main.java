package java_adv_1st_exper;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer c1 = new Computer(
				"Leveno",
				(CPU)Factory.get("AMD", 8, 1000),
				(RAM)Factory.get("Samsung", 8, 300),
				(Disk)Factory.get("WestDigitals", 512, 300),
				(MainBoard)Factory.get("Gigabyte", 300, 1000)
				);
		
		c1.showDescription();
		c1.showPrice();
		
		Computer c2 = new Computer(
				"Apple",
				(CPU)Factory.get("Intel", 6, 800),
				(RAM)Factory.get("Samsung", 16, 1000),
				(Disk)Factory.get("Seagate", 512, 350),
				(MainBoard)Factory.get("Gigabyte", 300, 1000)
				);
		Computer c3 = new Computer(
				"Dell",
				(CPU)Factory.get("Intel", 16, 2400.5),
				(RAM)Factory.get("Kingston", 16, 700),
				(Disk)Factory.get("Seagate", 1024, 1000),
				(MainBoard)Factory.get("Asus", 400, 1500)
				);
		ComputerStore s = new ComputerStore(c1,c2,c3);
		s.showProductTable();
	}

}
