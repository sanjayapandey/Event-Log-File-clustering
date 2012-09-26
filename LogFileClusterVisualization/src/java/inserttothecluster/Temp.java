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
public class Temp {

    /**
     * @param args the command line arguments
     */
//    public boolean testing(String str) {
//        boolean b = false;
//        final String REGEX = "\\d+";
//        String mystring = str;
//        String[] splictstring = mystring.split("\\.");
//        for (String s : splictstring) {
//            if (!s.matches(REGEX)) {
//                System.out.println("Non-integer type found! " + s);
//                return b;
//            }
//            b = true;
//        }
//        return b;
//    }
//
//    public boolean doesItContainIpWithPortAddr(String combineString) {
//        boolean returnIt = false;
//        String[] IpOrMac = combineString.split(":");
//        final String REGX = "\\d+";
//        if (testing(IpOrMac[0])) {
//
//            //Port address is not of zero length
//            if (IpOrMac[1].length() > 0) {
//
//                //Port address doesn't contain any characters other than numeric values
//                if (!IpOrMac[1].matches(REGX)) {
//                    return returnIt;
//                }
//            }
//            returnIt = true;
//        }
//        System.out.println("Does contain IP?");
//        return returnIt;
//    }
//    public void replaceMatching(String str){
//        //final String REGEX = "[\\s\\<\\>\\@\\-~`#+/*]+";
//        final String REGEX = ": | :+";
//    String displayString = str.replaceAll(REGEX, " ");
//        System.out.println("The initial string is: "+str+"\nAnd the final string is: "+displayString);
//    }
//    public boolean isItIntegerOrFloatNumber(String str){
//        boolean intFloat = false;
//        try{
//        if(!(Float.isNaN(0/(Float.parseFloat(str))))){
//        intFloat = true;
//        }
//        }
//        catch(NumberFormatException ex){
//            return false;
//        }
//        return intFloat;
//    }
//    private int bitlength = 8;
    public float calculateMode(String str) {
        int sumOfSquareOfKey = 0;
        
        StringBuilder key = new StringBuilder(str);
        
        for (int i = 0; i < Global.bitlength; i++) {
            int powerOfTwo = (int) Math.pow(2, (Global.bitlength - 1 - i));
            
            Character c = key.charAt(i);
            
            sumOfSquareOfKey += (int) Math.pow(powerOfTwo, 2) * Integer.parseInt(c.toString());
        }
        return ((float) Math.pow(sumOfSquareOfKey, 0.5));
    }

    public String fixBits(String str) {

        String returnString = "";
        
        if (str.length() > Global.bitlength) {
            System.out.println("\"" + str + "\" is too long to process. The maximum bit length possible to process is " + Global.bitlength);
            System.exit(1);
        }
        if (str.length() < Global.bitlength) {

            for (int j = 0; j < (Global.bitlength - str.length()); j++) {
                returnString += "0";
            }

            returnString += str;

        } else {
            returnString += str;
        }
        return returnString;

    }

    public void representBinary() {

        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        ArrayList<Integer> binaryArray = new ArrayList<Integer>();
//        integerArray.add(3);
//        integerArray.add(12);
        integerArray.add(254);
        String candidateKey = fixBits("110001111");

        System.out.println("Candidate Key: " + candidateKey);
        for (Integer integerValue : integerArray) {
            String binaryString = fixBits(Integer.toBinaryString(integerValue));

//            [Angle calculation using cosine angle relation]
            StringBuilder stbuf = new StringBuilder(binaryString);
            StringBuilder keybuf = new StringBuilder(candidateKey);

            float modOfCandidateKey = calculateMode(candidateKey);
            float modOfBinaryString = calculateMode(binaryString);
            float dotProduct = 0;

            for (int k = 0; k < Global.bitlength; k++) {

                int powerOfTwo = (int) Math.pow(2, (Global.bitlength - 1 - k));

                Character c1 = keybuf.charAt(k);
                Character c2 = stbuf.charAt(k);
                dotProduct += (powerOfTwo * Integer.parseInt(c1.toString())) * (powerOfTwo * Integer.parseInt(c2.toString()));
            }
            double theta = (double) Math.acos(dotProduct / (modOfBinaryString * modOfCandidateKey));

            System.out.println("Cosine angle with " + binaryString + " = " + theta * 180 / Math.PI);

        }
    }

    public static void main(String[] args) {

        Temp T = new Temp();
        T.representBinary();
    }
}
