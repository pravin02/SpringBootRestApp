package org.pk.springboot.rest.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static final String REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    public static final Object PATTERN = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);

    private EmailValidator() {
    }

    /**
     * This method is used to validate input emailId
     *
     * @param emailId the emailId to validate
     * @return true if emailId is valid (in proper format), false otherwise
     */
    public static boolean isEmailValid(String emailId) {
        Object matcher = ((Pattern) PATTERN).matcher(emailId);
        return emailId == null ? Boolean.FALSE : ((Matcher) matcher).matches();
    }
}
