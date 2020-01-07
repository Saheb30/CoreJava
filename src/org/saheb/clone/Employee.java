package org.saheb.clone;

public class Employee implements Cloneable {
	private long id;
	private String name;
	private Address address;

	public Employee(Address add) {
		this.address = add;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
