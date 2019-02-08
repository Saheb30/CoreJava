package lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class LambdaExceptionHandling {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> function = (a,b)->a+b;
		product(wrapper(function));
		
		BiConsumer<Integer, Integer> consumer = (a,b)->System.out.println("Consumer-->"+(a+b));
		product(wrapper(consumer));
		
	}
	private static void product(BiFunction<Integer, Integer, Integer> function){
		int result = function.apply(10,5);
		System.out.println("Inside BiFunction-->"+result);
	}

	private static BiFunction<Integer, Integer, Integer> wrapper(BiFunction<Integer, Integer, Integer> function){
		return (a,b)->{
			try {
				return a/b;
			}catch (Exception e) {
				System.out.println("Exception");
				return null;
			}
		};
	}
	
	
	private static void product(BiConsumer<Integer, Integer> consumer){
		consumer.accept(10,5);
	}
	
	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> consumer){
		return (a,b)->{
			try {
				System.out.println("inside BiConsumer wrapper-->"+a*b);
				consumer.accept(a, b);
			}catch (Exception e) {
				System.out.println("Exception");
			}
		};
	}
}
