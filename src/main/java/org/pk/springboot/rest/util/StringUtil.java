package org.pk.springboot.rest.util;

/**
 * @author Pravin P Patil
 * @apiNote Utility class for validations of string
 */
public class StringUtil {

    private StringUtil() {

    }

    /**
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str != null && !str.equals("") ? Boolean.FALSE : Boolean.TRUE;
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