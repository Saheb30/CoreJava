package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CreateInstance {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Animal ob1 = new Animal();
		Animal ob2 = Animal.class.newInstance();
		Animal ob3 = (Animal) ob1.clone(ob1);
		Animal ob4 = (Animal) Class.forName("test.Animal").newInstance();
		System.out.println("done");
		List<Integer> list = new ArrayList<>();
	}
}

class Animal implements Cloneable {
	public Object clone(Object obj) {
		return obj;
	}
}
