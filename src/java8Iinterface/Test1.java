package java8Iinterface;

public interface Test1 {
	int COUNT =10;
	default void defaultMethod () {
		System.out.println("inside test1 defaultMethod");
	}
	static void staticMethod() {
		System.out.println("inside test1 staticMethod");
	}
}
