/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

import global.Global;

/**
 * Computes the length of a line, There will be abnormal result when the message is of zero length. 
 *
 * @author lnkhanal
 */
public class LineCliper {

    private String returnString = "", originalString = "";
    private double c, m;

    public LineCliper(String str, double yIntercept, double slope) {
        this.originalString = str;
        this.c = yIntercept;
        this.m = slope;
    }

    public String getValue() {

        this.clipTheLine();
        return this.returnString;
    }

    private void clipTheLine() {
        StringBuilder bufString = new StringBuilder(this.originalString);

        int i;
        int j;

        int x1, x2;
        float y1, y2;

//        Counting the consecutive zeros'
        i = bufString.indexOf("1");
        x1 = ((i+1) / Global.bitSliceLength);
//        Counting the reverse consecutive zeros.
        bufString = bufString.reverse();
        j = bufString.indexOf("1");
        x2 = (this.originalString.length() / Global.bitSliceLength - j / Global.bitSliceLength - 1);
        y1 = (float) (m * x1 + c);
        y2 = (float) (m * x2 + c);

        this.returnString = String.format(x1 + "," + y1 + "," + x2 + "," + y2);

    }
}
