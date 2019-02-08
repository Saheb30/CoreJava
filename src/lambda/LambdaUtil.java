package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaUtil {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(2, "A"));
		empList.add(new Emp(4, "B"));
		empList.add(new Emp(1, "C"));
		empList.add(new Emp(3, "D"));
		
		sort(empList);
		streamSort(empList);
	}
	static void sort(List<Emp> empList) {
		Collections.sort(empList, (a,b)->a.getName().compareTo(b.getName()));//Sort the actual list
		show(empList);
	}
	static void streamSort(List<Emp> empList) {
		//It does not sort the actual list. It sorts the stream and collect into a new list
		List<Emp> tempList = empList.stream().sorted((a,b)->a.getId()-b.getId()).collect(Collectors.toList()); 
		show(tempList);
	}
	static void show(List<Emp> empList) {
		for(Emp it : empList) {
			System.out.println(it.getId()+"::"+it.getName());
		}
	}
	
}
class Emp{
	private int id;
	private String name;
	Emp(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
