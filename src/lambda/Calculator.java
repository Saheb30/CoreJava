package lambda;

import java.util.function.BiFunction;

public class Calculator {
	int multiple(int a, int b) {
		return a*b;
	}
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		//BiFunction<Integer, Integer, Integer> result = (a,b)->{return(a*b);};
		/*int num = result.apply(10, 20);
		System.out.println(num);*/
		//new Calculator().product(result);
		calc.product((a,b)->a*b);//lambda
		calc.product(calc::multiple);//lambda equivalent method reference
		//In case of lambda we put logic in lambda body itself but in case of 
		
		
	}
	private void product(BiFunction<Integer,Integer,Integer> biFunction) {
		System.out.println(biFunction.apply(10, 10));
	}
}
