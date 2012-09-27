/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

import global.Global;

/**
 *
 * @author user
 */
public class StandardDeviationComputer {
    String message,standarddeviation;
    public StandardDeviationComputer(String message){
        this.message = message;
    }
    public void computeStandardDeviation(){
        this.compute();
    }
    public String getVal(){
        return this.standarddeviation;
    }
    private void compute() {
       
        BinaryToDecimalComputer bintodecimal = new BinaryToDecimalComputer();

        float x = 0, xx = 0;
        int count = this.message.length() / Global.bitSliceLength;

        for (int i = 0; i < this.message.length(); i += Global.bitSliceLength) {

            String subString = this.message.substring(i, i + Global.bitSliceLength);
            bintodecimal.computeDecimal(subString);
            int decimalValue = bintodecimal.getVal();

            x += decimalValue;
            xx += decimalValue * decimalValue;
        }
        this.standarddeviation = String.format("" + Math.pow(xx / count - Math.pow(x / count, 2), 0.5));

    }
    
}
