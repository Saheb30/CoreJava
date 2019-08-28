package org.saheb.collection;

import java.util.stream.IntStream;

public class CollectionLazyInitializer {

	public static void main(String[] args) {
		/*
		 * List<Integer> listEager = new ArrayList<>(); for(int i =2; i<100; i++) {
		 * if(isPrime(i)) { listEager.add(i); } } System.out.println(listEager);
		 */

		System.out.println("processor:" + Runtime.getRuntime().availableProcessors());

		// IntStream.rangeClosed(1,
		// 100).filter(CollectionLazyInitializer::isPrime).forEach(System.out::println);
		IntStream.rangeClosed(1, 1000).filter(i -> {
			System.out.println("in filter..");
			return CollectionLazyInitializer.isPrime(i);
		}).forEach((i) -> {
			System.out.println("in foreach..");
			System.out.println(i);
		});

	}

	public static boolean isPrime(final int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++)
			if (number % i == 0)
				return false;
		return true;
	}
}
