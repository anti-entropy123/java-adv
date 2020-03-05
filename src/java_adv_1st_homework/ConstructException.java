package java_adv_1st_homework;

public class ConstructException extends Exception {
	ConstructException(){
		super("该类已经被初始化, 无法继续创造实例");
	}
}
