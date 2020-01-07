package org.saheb.clone;

public class Address implements Cloneable{
	String street;
	long pin;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
	      return super.clone();
	 }

}
