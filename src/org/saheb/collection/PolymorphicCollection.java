package org.saheb.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolymorphicCollection {
	public static void main(String[] args) {
		Map<String, Animal> map = new HashMap<>();
		Animal[] myParentArray = new Dog[10];

		Dog dog = new Dog();
		map.put("DOG", dog);

		List<Animal> list = new ArrayList<Animal>();
		list.add(dog);
	}
	void caller() {
		List<Animal> animalList = new ArrayList<Animal>();
		List<Cat> catList = new ArrayList<Cat>();
		List<Dog> dogList = new ArrayList<Dog>();
		addAnimals(animalList);
		//addAnimals(catList);//Will be error
		addAnimalsGeneric(catList);
		//addAnimals(dogList);//Will be error
		addAnimalsGeneric(dogList);
	}
	public void addAnimals(Animal[] animals) {
		animals[0] = new Animal();
		animals[1] = new Cat();
		animals[1] = new Dog();
	}

	public void addAnimals(List<Animal> myAnimalList) {
		myAnimalList.add(new Animal()); // Expected code.
		myAnimalList.add(new Cat()); // Yes this works.
		myAnimalList.add(new Dog()); // Any Animal subtype works.
	}
	static void addAnimalsGeneric(List<? extends Animal> list) {
		//Animal a = list.get(0);
	}

}

