package org.saheb.stream;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StringStream {
	public static void main(String[] args) {
		removeDuplicate("abaxb");
	}
	static void removeDuplicate(String input) {
		String temp =input.chars() //chars return IntStream
				.distinct()
				.mapToObj(a->(char) a)
				.map(s->s.toString())
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.joining());
				
		System.out.println(temp);
	}
}

