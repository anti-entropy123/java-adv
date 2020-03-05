package java_adv_1st_homework;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = {"A", "B"};
		Singleton s = new Singleton("java_adv_1st_homework", t);
		A a1 = (A)s.getInstance("A");
		a1.printMessage();
		
		A a2 = (A)s.getInstance("A"); 
		System.out.println(a1 == a2); // 这里 a1 和 a2 是同一个对象
		// try{B b = new B();}catch(Exception e) {System.out.println("失败");} // 抛出异常, 因为不允许直接访问构造器
		
		B b1 = (B)s.getInstance("B");
		b1.printMessage();
	}
}
