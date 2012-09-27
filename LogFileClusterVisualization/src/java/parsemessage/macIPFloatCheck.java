/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemessage;

/**
 *
 * @author lnkhanal
 */
public class macIPFloatCheck {

    public boolean isAMacAddress(String mac) {

        String[] substrings = mac.split(":");
        return substrings.length == 6 ? true : false;
    }

    public boolean isIPAddress(String IP) {
        String[] subps = IP.split("\\.");
        boolean isIpOrNot = false;
        final String REGEX = "\\d+";
        if (subps.length == 4) {
            for (String str : subps) {
                if (!str.matches(REGEX)) {
                    return false;
                }
            }
            isIpOrNot = true;
        }
        return isIpOrNot;
    }

    public boolean doesItContainIpWithPortAddr(String combineString) {
        boolean returnIt = false;
        String[] IpOrMac = combineString.split(":");
        final String REGX = "\\d+";
        if (isIPAddress(IpOrMac[0])) {

            //Port address is never of zero length
            if (IpOrMac[1].length() > 0) {

                //Port address doesn't contain any characters other than numeric values
                if (!IpOrMac[1].matches(REGX)) {
                    return returnIt;
                }
            }
            returnIt = true;
        }
        return returnIt;
    }

    public boolean isItIntegerOrFloatNumber(String str) {
        boolean intFloat = false;
        try {
            //NaN is not a number. this checks whether the floating point expression is undefined or not. e.g. divide by zero,square root of negative number etc.
            if (!(Float.isNaN(0 / (Float.parseFloat(str))))) {
                intFloat = true;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        return intFloat;
    }
}
