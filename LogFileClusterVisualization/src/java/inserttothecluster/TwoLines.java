/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.util.ArrayList;

/**
 *
 * @author lnkhanal
 */
public class TwoLines {

    public String fixBits(String str) {

        String returnString = "";

        if (str.length() / Global.bitSliceLength != 0) {

            for (int j = 0; j < (Global.bitSliceLength - str.length() % Global.bitSliceLength); j++) {
                returnString += "0";
            }

            returnString += str;

        } else {
            returnString += str;
        }
        return returnString;
    }

    public int computeDecimal(String str) {
        int returnInt = 0;

        StringBuilder stbuf = new StringBuilder(str);

        for (int i = 0; i < Global.bitSliceLength; i++) {
            int powerOfTwo = (int) Math.pow(2, (Global.bitSliceLength - 1 - i));

            Character c = stbuf.charAt(i);

            returnInt += (powerOfTwo * Integer.parseInt(c.toString()));
        }
        return returnInt;
    }

    public ArrayList<String> convertBinaryToDecimal(String str) {
        ArrayList<String> bitArray = new ArrayList<String>();

        int bitLength = str.length();

        String formatedString = fixBits(str);

//        System.out.println("total bits are:" + formatedString.length() + "\nBefore it was:" + bitLength);
        Global.numberOfSlices = formatedString.length() / Global.bitSliceLength;

        for (int i = 0, j = 0; i < bitLength; i += Global.bitSliceLength, j++) {
            bitArray.add(String.format(j + "," + computeDecimal(formatedString.subSequence(i, i + Global.bitSliceLength).toString())));
        }
//        System.out.println("******************CORRESPONDING POINTS TO PLOT***************************");
//        for (String displayString : bitArray) {
//            String[] points = displayString.split(",");
//            //System.out.println(points[1]);
//        }
        return bitArray;


    }
}
