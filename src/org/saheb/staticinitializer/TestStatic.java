package org.saheb.staticinitializer;

public class TestStatic {
	
	static {
		System.out.println("in static block");
		TestStatic ob = new TestStatic();
		System.out.println(ob);
	}
	public static void main(String[] args) {
		System.out.println("in main");
	}
	/*We can run java without main method , but make sure that your JDK is below 1.7. Above 1.7 its noot supported.*/
}
