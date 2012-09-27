/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

import global.Global;
import java.util.ArrayList;

/**
 * Takes a bit string and calculates the decimal values for different slices in
 * the string and returns the list of decimal and the corresponding index
 * values.
 *
 * @author lnkhanal
 */
public class PointsFixer {

    private String originalString;
    private ArrayList<String> returnList;

    public void pointsFixer(String str) {
        this.originalString = str;
    }

    public ArrayList<String> getVal() {
        return this.returnList;
    }

    public void fixpoints() {
        this.convert();
    }

    private void convert() {
        ArrayList<String> decimalArray = new ArrayList<String>();
        BinaryToDecimalComputer bintodec = new BinaryToDecimalComputer();

        int bitLength = this.originalString.length();

        Global.numberOfSlices = this.originalString.length() / Global.bitSliceLength;

        for (int i = 0, j = 0; i < bitLength; i += Global.bitSliceLength, j++) {
            bintodec.computeDecimal(this.originalString.subSequence(i, i + Global.bitSliceLength).toString());
            int decimalVal = bintodec.getVal();
            decimalArray.add(String.format(j + "," + decimalVal));
        }

        this.returnList = decimalArray;
    }
}
