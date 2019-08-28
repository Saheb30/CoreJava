package test;

public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Animal ob1 = new Animal();
		Animal ob2 = Animal.class.newInstance();
		Animal ob3 = (Animal) ob1.clone(ob1);//It will give compile time error is Animal class does not implement cloneable
											 // and override clone method
		System.out.println(ob3.equals(ob1));//will print true
		Animal ob4 = (Animal) Class.forName("test.Animal").newInstance();
		System.out.println("done");
	}
}
class Animal implements Cloneable{
	public Animal clone(Animal ob1) {
		return ob1;
	}

}
