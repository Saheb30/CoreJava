package org.saheb.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericCollection<T> {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		
		iterate(list);
		iterate2(list);
		
		iterate(list2);
		iterate2(list2);
	}
	
	static void add(List<Animal> list) {
		list.add(new Animal());
		list.add(new Cat());
		list.add(new Dog());
	}
	static void addGeneric(List<? super Animal> list) {
		list.add(new Animal());
		list.add(new Cat());
		list.add(new Dog());
		//Animal a = list.get(0);
	}
	static void addGeneric2(List<? extends Animal> list) {
		//list.add(new Cat());
	}
	static void processList(List<? extends Animal> list) {
		Animal a = list.get(0);
	}
	static void iterate(List<?> list) {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//list.add(list.remove(0)); Error. Return type of list.remove() and parameter type of list.add() might be different
	}
	static <T> void iterate2(List<T> list) {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		list.add(list.remove(0));
	}
	public <E> void printObjectsExceptOne(List<E> list, Object object) {
		
	}
	public void printObjects(List<?> list, Object object) {
		
	}
}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}
