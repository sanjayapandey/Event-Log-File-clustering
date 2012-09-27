/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticalanalysis;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lnkhanal
 */
public class CurveFitter {

    ArrayList<String> lineList;
     String linelist;
    public void  curveFitter(ArrayList<String> ArrList) {
        this.lineList = ArrList;
    }

    public String getVal() {
        return this.linelist;
    }
    public void fitTheCurve(){
        this.fit();
    }

    private void fit() {

        int sumX = 0, sumXSquare = 0, count = 0, sumXY = 0, sumY = 0;

        Iterator<String> st = this.lineList.iterator();

        while (st.hasNext()) {

            count++;
            String[] coordinate = st.next().split(",");

            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);

            sumX += x;
            sumY += y;
            sumXSquare += x * x;
            sumXY += x * y;
        }
//        Applying regression. Line fitting
        float determinant = (float) Math.abs(Math.pow(sumX, 2) - count * sumXSquare);
        float slope = (float) (((sumX * sumY) - sumXY * count) / determinant);
        float intercept = (float) ((-1 * sumXSquare * sumY + sumXY * sumX) / determinant);

//        System.out.println("Sumx = "+sumX+"\nSumY = "+sumY+"\nSumXY = "+sumXY+"\nSumXSquare = "+sumXSquare+"\nCount = "+count);
        
        this.linelist = String.format(slope + ":" + intercept);

    }
}
