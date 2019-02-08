package encoding;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Algo {
	

	public static void main(String[] args) throws UnsupportedEncodingException {
		String password = "hello";

        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            digest.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Digest length::"+digest.getDigestLength());
        byte[] rawData = digest.digest();
        for(int i=0;i<rawData.length;i++) {
        	System.out.println(rawData[i]);
        }
        //System.out.println("Rawdata->"+rawData.toString());

        String bencoder = Base64.getUrlEncoder().encode(rawData).toString();
     // Decode
       /* byte[] base64decodedBytes = Base64.getUrlDecoder().decode(bencoder);
		
        System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));*/

        //System.out.println("PHPBB           : " + bencoder);
        //System.out.println("MVNFORUM        : " + getMD5_Base64(password));

	}
	public static synchronized String getMD5_Base64(String input) {
        // please note that we dont use digest, because if we
        // cannot get digest, then the second time we have to call it
        // again, which will fail again
        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (digest == null)
            return input;

        // now everything is ok, go ahead
        try {
            digest.update(input.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        byte[] rawData = digest.digest();
        String bencoder = Base64.getEncoder().encode(rawData).toString();
        return bencoder;
    }
	

}
