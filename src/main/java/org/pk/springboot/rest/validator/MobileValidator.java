package org.pk.springboot.rest.validator;

import org.pk.springboot.rest.util.StringUtil;

public class MobileValidator {

    private MobileValidator() {

    }

    /**
     * @param str
     * @return false if mobile not 10 digit
     */
    public static boolean isValidMobileNumber(String str) {
        if (str == null)
            return false;
        else if ((str.length() < 11 && str.length() > 9) && StringUtil.isDigit(str))
            return true;
        return false;
    }

}
