package org.saheb.clone;

public class Address implements Cloneable{
	String address;
	long pin;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPin() {
		return pin;
	}
	/*public void setPin(long pin) {
		this.pin = pin;
	}*/
}
