package org.pk.springboot.rest.util;

/**
 * Utility class for validations of string
 * 
 */
public class StringUtil {

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null && !str.equals(""))
			return false;
		return true;
	}

	/**
	 * method to check passed string is digit or not
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str) {
		char[] digits = str.toCharArray();
		for (char c : digits)
			if (!Character.isDigit(c))
				return false;
		return true;
	}
}