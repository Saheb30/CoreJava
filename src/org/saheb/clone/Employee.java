package org.saheb.clone;

public class Employee implements Cloneable{
	private long id;
	private String name;
	private Address address;
	public long getId() {
		return id;
	}
	/*public void setId(long id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	/*public void setName(String name) {
		this.name = name;
	}*/
	public Address getAddress() {
		return address;
	}
	/*public void setAddress(Address address) {
		this.address = address;
	}*/
	Object clone(Object obj) throws CloneNotSupportedException{
		return obj;
		//throw new CloneNotSupportedException();
	}
	public Employee(Address add) {
		this.address = add;
	}
}
