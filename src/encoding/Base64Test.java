package encoding;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String base64encodedStr = Base64.getEncoder().encodeToString("TutorialsPoint?€—java8".getBytes("utf-8")); 
		System.out.println("Base64 Encoded String (Basic) :" + base64encodedStr);
		
        // Decode
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedStr);
		
        System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
        
        base64encodedStr = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
        System.out.println("Base64 Encoded String (URL) :" + base64encodedStr);
	}

}
