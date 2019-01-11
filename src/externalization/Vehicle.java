package externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Vehicle implements Externalizable{

	private String company;
	private String model;
	private String color;
	private int speed;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(company);
		out.writeObject(model);
		out.writeObject(color);
		out.writeInt(speed);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		company = String.valueOf(in.readObject());
		model = String.valueOf(in.readObject());
		color = String.valueOf(in.readObject());
		speed = in.readInt();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Vehicle [company=" + company + ", model=" + model + ", color=" + color + ", speed=" + speed + "]";
	}

}
