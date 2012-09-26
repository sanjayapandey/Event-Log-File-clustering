/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

/**
 *
 * @author lnkhanal
 */
public class CohenSutharlandLineCliper {

//    public double computeDecimalWithBitCount(int bitCount) {
//        double returnValue = 0;
//        for (int i = bitCount; i > 0; i--) {
//            returnValue += Math.pow(2, i - 1);
//        }
//        return returnValue;
//    }

    public String computeX1X2(String str) {

        String returnString = "";
        StringBuilder bufString = new StringBuilder(str);

        int i = 0;
//        Counting the consecutive zeros'

        i = bufString.indexOf("1");

        float x1 = i / (float) Global.bitSliceLength;
        int j = 0;

//        Counting the reverse zeros.
        bufString = bufString.reverse();
        j = bufString.indexOf("1");

        float x2 = str.length() / Global.bitSliceLength - j / (float) Global.bitSliceLength - 1;
        returnString = String.format(x1 + "," + x2);
        return returnString;
    }

    public String clipTheLine(double slope, double yIntercept, String wholeString) {
        String returnString = "";

        double x1 = 0, x2, y1 = 0, y2;
        double c = yIntercept, m = slope;
//        double decimalValue = computeDecimalWithBitCount(Global.bitSliceLength);

        String[] x1x2 = computeX1X2(wholeString).split(",");

        x1 = Float.parseFloat(x1x2[0]);
        x2 = Float.parseFloat(x1x2[1]);

        y1 = m * x1 + c;
        y2 = m * x2 + c;

//        if (y1 < 0) {
//            y1 = 0;
//        }
//        if (y1 > decimalValue) {
//            y1 = decimalValue;
//        }
//        if (y2 < 0) {
//            y2 = 0;
//        }
//        if (y2 > decimalValue) {
//            y2 = decimalValue;
//        }
        returnString = String.format(x1 + "," + y1 + "," + x2 + "," + y2);
        return returnString;
    }
}
