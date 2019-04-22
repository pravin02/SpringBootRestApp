package org.pk.springboot.rest.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static final String regExpn = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	public static final Object pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);

	/**
	 * This method is used to validate input emailId
	 * 
	 * @param inputEmail
	 *            the emailId to validate
	 * @return true if emailId is valid (in proper format), false otherwise
	 */
	public static boolean isEmailValid(String emailId) {
		Object matcher = ((Pattern) pattern).matcher(emailId);
		return emailId == null ? false : ((Matcher) matcher).matches();
	}
}
