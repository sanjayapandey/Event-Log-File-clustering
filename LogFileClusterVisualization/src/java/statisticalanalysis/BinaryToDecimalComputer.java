/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

import global.Global;

/**
 *  Computes the decimal value of the given bits in a string and returns it.
 * @author lnkhanal
 */
public class BinaryToDecimalComputer {
    private String binaryString;
    private int decimalValue;
//    public BinaryToDecimalComputer(String bitString){
//           this.binaryString = bitString;
//}
    public void computeDecimal(String bitString){
        this.binaryString = bitString;
        compute();
    }
    public int getVal(){
        return this.decimalValue;
    }
    private void compute() {
        int returnInt = 0;

        StringBuilder stbuf = new StringBuilder(this.binaryString);

        for (int i = 0; i < Global.bitSliceLength; i++) {
            int powerOfTwo = (int) Math.pow(2, (Global.bitSliceLength - 1 - i));

            Character c = stbuf.charAt(i);

            returnInt += (powerOfTwo * Integer.parseInt(c.toString()));
        }
        this.decimalValue = returnInt;
    }
}
