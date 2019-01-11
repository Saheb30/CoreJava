package org.saheb.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class MapSort {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("E", 2);
		map.put("D", 4);
		map.put("C", 5);
		map.put("B", 3);
		map.put("A", 3);
		
		sortMapStream(map);
		mapToQueue(map);
		sortMap(map);
	}
	static void sortMap(Map<String, Integer> map) {
		System.out.println("inside sortMap");
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(set);
		Collections.sort(list, (e1, e2)->e1.getValue()-e2.getValue());
		//list.sort((e1, e2)->e1.getValue()-e2.getValue());
		Iterator<Entry<String, Integer>> itr = list.iterator();
		while(itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}
	static void sortMapStream(Map<String, Integer> map) {
		System.out.println("inside sortMapStream");
		List<Entry<String, Integer>> list = map.entrySet()
											.stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(Collectors.toList());
		
		Iterator<Entry<String, Integer>> itr = list.iterator();
		while(itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}
	private static void mapToQueue(Map<String, Integer> map) {
		System.out.println("inside mapToQueue");
		//Set<Entry<String, Integer>> set = map.entrySet();
		//Iterator<Entry<String, Integer>> itr = set.iterator();
		Queue<Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2)->e1.getKey().compareTo(e2.getKey()));
		queue.addAll(map.entrySet());
		/*while(itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			queue.add(entry);
		}*/
		
		while (queue.size() != 0) {
			Entry<String, Integer> entry = queue.poll();
			//System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}

}
