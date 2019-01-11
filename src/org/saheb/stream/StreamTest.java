package org.saheb.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StreamTest {

	public static void main(String[] args) {
		new StreamTest().sortBykey();
	}
	private void sortBykey() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
		System.out.println("---------------");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
	}
	/*public static <T> boolean isEqual(T g1, T g2){
		return g1.get().equals(g2.get());
	}*/

}
