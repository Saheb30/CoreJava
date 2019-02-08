package methodreference;

public class FunctionalInterfaceTest {
	static void show() {
		System.out.println("inside class");
	}
	public static void main(String[] args) {
		//ICalculator calc = ()->System.out.println("inside");//lambda
		ICalculator calc = FunctionalInterfaceTest::show; //return type of show() and display() must be same
		calc.display();
	}
}


@FunctionalInterface
interface ICalculator{
	public void display();
}
