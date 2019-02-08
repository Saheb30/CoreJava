package test;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Animal ob1 = new Animal();
		Animal ob2 = Animal.class.newInstance();
		//Animal ob3 = (Animal) ob1.clone(ob1);
		Animal ob4 = (Animal) Class.forName("test.Animal").newInstance();
		System.out.println("done");
	}
}
class Animal {

}
