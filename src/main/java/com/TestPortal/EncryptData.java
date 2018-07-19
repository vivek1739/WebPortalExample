package com.TestPortal;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptData {
	
	private static EncryptData encryptData=new EncryptData();
	
	private EncryptData(){}

	public static EncryptData getEncryptData() {
		return encryptData;
	}
	
	
	public String encrypt(Login obj){
		byte[] key=null;
		byte[] encrypted=null;
		//prepare key
		    try {
				key = ("vivek").getBytes("UTF-8");
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				key = sha.digest(key);
				key = Arrays.copyOf(key, 16); // use only first 128 bit/ 16 bytes
				SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

   
				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

				encrypted = cipher.doFinal((obj.getUsername()+","+obj.getPassword()).getBytes());//data to be encrypted
					
				// System.out.println("encrypted string in encrypt class: " + encrypted.toString());

				
					
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		return encrypted.toString();
		}

	public String decrypt(String string) {
		String originalString=null;
		byte[] key=null;
		
		try {
			byte[] encrypted=string.getBytes("UTF-8");
			key = ("vivek").getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); // use only first 128 bit/ 16 bytes
			SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] original = cipher.doFinal(encrypted);
			originalString = new String(encrypted);
			System.out.println("Decrypted value: "+originalString);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return originalString;
	}
	

}
