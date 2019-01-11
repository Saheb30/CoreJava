package externalization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		deserilize();
	}

	public static void serilize() throws IOException {
		Apple apple = new Apple();
		apple.setAppleColor("RED");
		apple.setAppleOriginalCost(10);
		apple.setAppleMRPCost(25);

		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Saheb\\apple.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(apple);
		objectOutputStream.close();
	}
	public static void deserilize() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Saheb\\apple.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		 
		Apple apple = (Apple)objectInputStream.readObject();
		System.out.println("in Main->"+apple.getAppleColor());
		System.out.println("in Main->"+apple.getAppleMRPCost());
		System.out.println("in Main->"+apple.getAppleOriginalCost());
		objectInputStream.close();
	}

}
class Apple implements Externalizable {
	private int appleOriginalCost;
	private int appleMRPCost;
	private String appleColor;

	public Apple() {
		System.out.println("Apple Constructor...");
	}
	public int getAppleOriginalCost() {
		return appleOriginalCost;
	}
	public void setAppleOriginalCost(int appleOriginalCost) {
		this.appleOriginalCost = appleOriginalCost;
	}
	public int getAppleMRPCost() {
		return appleMRPCost;
	}
	public void setAppleMRPCost(int appleMRPCost) {
		this.appleMRPCost = appleMRPCost;
	}
	public String getAppleColor() {
		return appleColor;
	}
	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("read External Starts");
		System.out.println(appleMRPCost);
		System.out.println(appleColor);

		appleMRPCost = in.readInt();
		appleColor = (String) in.readObject();

		System.out.println("read External Ends");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(appleMRPCost);
		out.writeObject(appleColor);
	}
}
