package org.saheb.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackedCollection {
	public static void main(String[] args) {
		SortedMap<Integer,String> map = new TreeMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		
		SortedMap<Integer,String> subMap = map.subMap(1, 4);//Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
		System.out.println("Sub Map->"+subMap);//Sub Map->{1=One, 2=Two, 3=Three}
		
		SortedMap<Integer,String> headMap = map.headMap(2);//Returns a view of the portion of this map whose keys arestrictly less than toKey
		System.out.println("Head map->"+headMap);//Head map->{1=One}
		
		SortedMap<Integer,String> tailMap = map.tailMap(2); //Returns a view of the portion of this map whose keys aregreater than or equal to fromKey
		System.out.println("Tail map->"+tailMap);//Tail map->{2=Two, 3=Three, 4=Four}
		
		//Any changes to returned map will reflect in the original map
	}
}
