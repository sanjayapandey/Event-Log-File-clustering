/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lnkhanal
 */
public class computePoints {

//    This method is to compute the standard deviation of different points in a long string forming with the bits.
    private String computeStandardDeviation(String str1) {
        Temp TEMP = new Temp();
        TwoLines TL = new TwoLines();
        
        String str = TEMP.fixBits(str1);
        
        float x = 0, xx = 0;
        int count = str.length() / Global.bitSliceLength;

        for (int i = 0; i < str.length(); i += Global.bitSliceLength) {

            String subString = str.substring(i, i + Global.bitSliceLength);
            int decimalValue = TL.computeDecimal(subString);

            x += decimalValue;
            xx += decimalValue * decimalValue;
        }
        return String.format("" + Math.pow(xx / count - Math.pow(x / count, 2), 0.5));

    }

    public String points(ArrayList<String> str, String wholeString) {
        String returnString = "";
        String[] stringToIterate;

        Iterator<String> st = str.iterator();

        float x1 = 0, y1 = 0, x2 = 0, y2 = 0,xmid = 0;

        while (st.hasNext()) {
            stringToIterate = st.next().split(":");
            
//            This x1 = 0 and the x2 = Global.numberOfSlices -1 assignment is wrong. Because there maynot be the starting point always at the origin.
//            soln: DONE dana DON! we computed the x1 and x2 values by knowing the continuous zero values from the begning and from the last.
            CohenSutharlandLineCliper CL = new CohenSutharlandLineCliper();
            String points = CL.clipTheLine(Float.parseFloat(stringToIterate[0]), Float.parseFloat(stringToIterate[1]),wholeString);
            String[] x1x2 = points.split(",");
            x1 = Float.parseFloat(x1x2[0]);
            y1 = Float.parseFloat(x1x2[1]);
            x2 = Float.parseFloat(x1x2[2]);
            y2 = Float.parseFloat(x1x2[3]);
            xmid = x1+Math.abs((x2-x1)/2);
        }
        
//        This global variable is not working properly. pay some time to search..:)
//        Soln: just check the blog "http://lnmama.blogspot.com/2012/06/public-variable-in-java.html" :D
        
        float lengthOfLine = (float) Math.pow(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2), 0.5);
        
        String standardDeviation = computeStandardDeviation(wholeString);
        returnString = String.format(x1 + "," + y1 + "," + x2 + "," + y2 + "," + lengthOfLine + "," + standardDeviation+","+xmid);
        
        return returnString;
    }
}
