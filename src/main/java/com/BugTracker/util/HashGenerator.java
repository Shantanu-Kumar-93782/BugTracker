package com.BugTracker.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


public class HashGenerator{

	public static String generateMD5(String word) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		byte[] byteArrayOfWord = word.getBytes("UTF-8");
		MessageDigest messageDigestMD5 = MessageDigest.getInstance("MD5");
		byte[] digestedString = messageDigestMD5.digest(byteArrayOfWord);
		return new String(Hex.encodeHex(digestedString));
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(generateMD5("admin"));
		
	}
}
