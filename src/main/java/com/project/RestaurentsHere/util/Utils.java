package com.project.RestaurentsHere.util;

import java.util.Random;
import java.util.UUID;

public class Utils {

	public static String getFormattedRoomName(String name) {
		StringBuffer s = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < name.length(); i++) {
			if (ch == ' ' && name.charAt(i) != ' ')
				s.append(Character.toUpperCase(name.charAt(i)));
			else
				s.append(name.charAt(i));
			ch = name.charAt(i);
		}
		return s.toString().trim().replaceAll("\\s", "");
	}

	public static String getRandomPassword() {
		return getAlphanumericString(8, "aA");
	}

	public static String getRandomString() {
		return getAlphanumericString(16, "aA");
	}

	public static String getRandomAlphaNumericString() {
		return getAlphanumericString(16, "aA#");
	}

	public static String getLongRandomAlphaNumericString() {
		return getAlphanumericString(32, "aA#");
	}

	public static String getOneTimePassword() {
		return getNumericString(6);
	}

	public static String getRandomOTP() {
		final Random generator = new Random();
		return String.valueOf(100000 + generator.nextInt(900000));
	}

	public static synchronized String getUniqueString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	private static String getAlphanumericString(int length, String chars) {
		String mask = "";
		if (chars.indexOf('a') > -1)
			mask += "abcdefghijklmnopqrstuvwxyz";
		if (chars.indexOf('A') > -1)
			mask += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (chars.indexOf('#') > -1)
			mask += "0123456789";
		if (chars.indexOf('!') > -1)
			mask += "!@#$%&.";
		String result = "";
		for (int i = length; i > 0; --i)
			result += mask.charAt((int) Math.floor(Math.random() * mask.length()));
		return result;
	}

	private static String getNumericString(int length) {
		String mask = "";
		mask += "0123456789";
		String result = "";
		for (int i = length; i > 0; --i)
			result += mask.charAt((int) Math.floor(Math.random() * mask.length()));
		return result;
	}

}
