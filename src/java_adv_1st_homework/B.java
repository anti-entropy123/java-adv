package java_adv_1st_homework;

public class B extends Singletonable{
	static int limit = 1;
	B() throws ConstructException{
		super();
		if(limit > 0) {
			limit--;
		} else {
			throw new ConstructException();
		}
	}
	void printMessage() {
		System.out.println("I'm B");
	}
}
