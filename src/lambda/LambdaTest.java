package lambda;

public class LambdaTest {
	
	public static void main(String[] args) {
		Add add2 = new AddImpl();
		int result2 = add2.add(10, 20);
		System.out.println(result2);
		
		//OR
		
		Add add = (a,b)->{return (a+b);};
		int result = add.add(10, 30);
		System.out.println(result);
	}
}
interface Add{
	int add(int i, int j);
	//int sub();
}
class AddImpl implements Add{
	@Override
	public int add(int i, int j) {
		return i+j;
	}
}
