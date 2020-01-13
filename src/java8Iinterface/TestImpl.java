package java8Iinterface;

public class TestImpl implements Test1, Test2{

	@Override
	public void defaultMethod() {
		Test1.super.defaultMethod();
		Test2.super.defaultMethod();
	}
	public static void main(String[] args) {
		new TestImpl().defaultMethod();
		System.out.println("Test1 constant:"+Test1.COUNT);
		Test1.staticMethod();
		System.out.println("Test2 constant:"+Test2.COUNT);
		Test2.staticMethod();
	}

}
