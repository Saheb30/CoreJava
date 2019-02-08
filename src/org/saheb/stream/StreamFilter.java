package org.saheb.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamFilter {
	
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Mouse", 150.00, 10));
		list.add(new Product(2, "Keyboard", 200.00, 20));
		list.add(new Product(3, "Monitor", 5000.00, 5));
		list.add(new Product(4, "Printer", 7000.00, 15));
		
		StreamFilter filter = new StreamFilter();
		filter.filter(list);
	}
	private void filter(List<Product> list) {
		list.stream().filter(a->a.getPrice()>200).collect(Collectors.toList()).forEach(System.out::println);
		
		//Maximum 
		Product product = list.stream().max((a,b)->a.getPrice().intValue()-b.getPrice().intValue()).get();
		System.out.println("max::"+product);
		
		//Average
		double avg = list.stream().mapToDouble(a->a.getPrice()).average().getAsDouble();
		System.out.println("Avg::"+avg);
		
		//Get a particular property
		list.stream().map(a->a.getName()).collect(Collectors.toList()).forEach(System.out::println);
		
		//Sum
		double sum = list.stream().mapToDouble(a->a.getPrice()).sum();
		System.out.println("Sum->"+sum);
		
		Optional<Double> reduceSum = list.stream().map(a->a.getPrice()).reduce((a,b)->a+b);
		reduceSum.ifPresent(System.out::println);
	}
}
