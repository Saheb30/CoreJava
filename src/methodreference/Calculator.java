package methodreference;

import java.util.function.BiFunction;

public class Calculator {
	static int  multiply(int a, int b) {
		return a*b;
	}
	public static void main(String[] args) {
		//BiFunction<Integer, Integer, Integer> result = (a,b)->a*b;//lambda
		BiFunction<Integer, Integer, Integer> result = Calculator::multiply;//equivalent of above mentioned lambda
		System.out.println(result.apply(10, 20));
	}
}
