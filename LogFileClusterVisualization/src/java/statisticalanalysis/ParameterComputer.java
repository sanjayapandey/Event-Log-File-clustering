/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

/**
 * Computes the standard deviation of different points in a long string forming
 * with the bits.
 *
 * @author lnkhanal
 */
public class ParameterComputer {

    String slopeintercept, originalmessage, parameters;

    public void parameterComputer(String slopeintercept, String wholeString) {
        this.originalmessage = wholeString;
        this.slopeintercept = slopeintercept;
    }

    public String getVal() {
        return this.parameters;
    }

    public void computeParameters() {
        this.compute();
    }

    private void compute() {
        String returnString;
        String[] slopeNIntercept;

        float x1, y1, x2, y2, xmid;

        slopeNIntercept = this.slopeintercept.split(":");

        LineCliper linecliper = new LineCliper(this.originalmessage, Float.parseFloat(slopeNIntercept[0]), Float.parseFloat(slopeNIntercept[1]));
        String points = linecliper.getValue();
        String[] x1x2 = points.split(",");
        
        x1 = Float.parseFloat(x1x2[0]);
        y1 = Float.parseFloat(x1x2[1]);
        x2 = Float.parseFloat(x1x2[2]);
        y2 = Float.parseFloat(x1x2[3]);
        xmid = x1 + Math.abs((x2 - x1) / 2);

        float lengthOfLine = (float) Math.pow(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2), 0.5);

        StandardDeviationComputer sdcomputer = new StandardDeviationComputer(this.originalmessage);
        sdcomputer.computeStandardDeviation();
        String standardDeviation = sdcomputer.getVal();
        
        returnString = String.format(x1 + "," + y1 + "," + x2 + "," + y2 + "," + lengthOfLine + "," + standardDeviation + "," + xmid);

        this.parameters = returnString;
    }
}
