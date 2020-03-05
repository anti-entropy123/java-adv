package java_adv_1st_homework;

public class A extends Singletonable{
	static int limit = 1;
	A() throws ConstructException{
		super();
		if(limit > 0) {
			limit--;
		} else {
			throw new ConstructException();
		}
	}
	void printMessage() {
		System.out.println("I'm A");
	}
}
