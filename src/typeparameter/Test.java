package typeparameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		List<Mango> mangoList = new ArrayList<>();
		//maxSimple(appleList); Error. As Apple class did not implement Comparable 
		max(appleList);
		maxSimple(mangoList);
		max(mangoList);
		
	}
	static <T extends Comparable<T>> T maxSimple(Collection<T> coll) {  //Only those class are allowed which implemented Comparable
		return null;
	}

	static <T extends Comparable<T>> T max(Collection<? extends T> coll) { //Only those class are allowed which implemented Comparable or
																			// It's super class implemented comparable
		return null;
	}
}

class Fruit implements Comparable<Fruit> {

	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Apple extends Fruit {
}

class Orange extends Fruit {
}
class Mango implements Comparable<Mango>{

	@Override
	public int compareTo(Mango o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

	
