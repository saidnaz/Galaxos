package fr.isika.cda.galaxos.repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.xml.bind.DatatypeConverter;

public class Cryptage {
//    public static String SALT = "CrypteMeLet'sgo!!";
//
//    public static String crypteString(String password, String salt) throws NoSuchAlgorithmException {
//        password = password + salt;
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[] digest = md.digest();
//        String result = DatatypeConverter.printHexBinary(digest).toUpperCase();
//        return result;}

public static String encryptPassword(String password) {
	String sha1 = "";
	try {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.reset();
		md.update(password.getBytes("UTF-8"));
		sha1 = byteToHex(md.digest());
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	return sha1;
}

private static String byteToHex(final byte[] hash) {
	Formatter formatter = new Formatter();
	for (byte b : hash) {
		formatter.format("%02x", b);
	}
	String result = formatter.toString();
	formatter.close();
	return result;
}
    
   

/*
 * public static void main(String[] args) {
 * 
 * String resul= null; resul = encryptPassword( "azerty");
 * System.out.println(resul); }
 */
}