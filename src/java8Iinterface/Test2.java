package java8Iinterface;

public interface Test2 {
	int COUNT =20;
	default void defaultMethod () {
		System.out.println("inside test2 defaultMethod");
	}
	static void staticMethod() {
		System.out.println("inside test2 staticMethod");
	}
}
