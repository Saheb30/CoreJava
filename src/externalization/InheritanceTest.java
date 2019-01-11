package externalization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InheritanceTest {

	public static void main(String[] args) {
		Car car = new Car();
        car.setCcOfEngine(1000);
        car.setLicenseNumber("AW-23-6528");
        car.setNumberOfDoors(4);
        car.setColor("Black");
        car.setCompany("Mercedes");
        car.setModel("Mercedez- Benz -Q");
        try {
           
            serialize(car, "serialization.txt");
            Car carOutput = (Car)deserialize("serialization.txt");
            
            System.out.println(carOutput.toString());
 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

	}

	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	public static void serialize(Object obj, String fileName) throws IOException {

		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.close();
	}

}
