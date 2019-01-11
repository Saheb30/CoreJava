package externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car extends Vehicle implements Externalizable {
	private Integer ccOfEngine;
	private String licenseNumber;
	private Integer numberOfDoors;

	public Integer getCcOfEngine() {
		return ccOfEngine;
	}

	public void setCcOfEngine(Integer ccOfEngine) {
		this.ccOfEngine = ccOfEngine;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	@Override
	public String toString() {

		return super.toString() + "\n" + "Car [ccOfEngine=" + ccOfEngine + ", licenseNumber=" + licenseNumber
				+ ", numberOfDoors=" + numberOfDoors + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeInt(ccOfEngine);
		out.writeObject(licenseNumber);
		out.writeInt(numberOfDoors);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		ccOfEngine = in.readInt();
		licenseNumber = String.valueOf(in.readObject());
		numberOfDoors = in.readInt();
	}
}
