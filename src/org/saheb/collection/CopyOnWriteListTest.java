package org.saheb.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {

	public static void main(String[] args) {
		new CopyOnWriteListTest().testCopyList();
		//mapTest();
		//joinerTest();
	}
	 void testCopyList(){
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
        list.add("5");
		Iterator<String> it = list.iterator();
		System.out.println(list.hashCode());
		 while(it.hasNext()){ 
            System.out.println("list is:"+list);
            String str = it.next();
            System.out.println("Iterator->"+str);
            if(str.equals("2")) {
            	list.remove("5");
            }
            if(str.equals("3")) {
            	list.add("6");
            }
            //below code don't throw ConcurrentModificationException because it doesn't change modCount variable of list
            if(str.equals("4")) {
            	list.set(1, "7");//here 1 is index
            }
        }
	}
	static void mapTest() {
		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		//Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println("Map hascode-->"+map.hashCode());
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			System.out.println("Key-->"+entry.getKey());
			map.remove(1);
			System.out.println("After remove map size-->"+map.size());
		}
		
		System.out.println("After remove map size-->"+map.size());
		System.out.println("After remove map hashcode-->"+map.hashCode());
	}
	static void joinerTest() {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		String result = String.join(", ", set);
		System.out.println(result);
	}
}
