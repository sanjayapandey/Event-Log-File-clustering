/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import representbinary.BinarRepresentetor;

/**
 *
 * @author lnkhanal
 */
public class MajorBagOfWords {

    /**
     * @param args the command line arguments
     */
    public void callMethods(String originalMessage) throws IOException {

        String dir = "D:/Major/clusters/";

        Temp TMP = new Temp();
        TwoLines TL = new TwoLines();
        curveFit CF = new curveFit();
        computePoints CP = new computePoints();
        BinarRepresentetor binaryRepresentetor = new BinarRepresentetor();
        
         ArrayList<String> messageinfo = new ArrayList<String>();
        
        String messageValue = binaryRepresentetor.binaryRepresentationOfLogLine(originalMessage);
        messageValue = TMP.fixBits(messageValue);

        ClusterChooser CC = new ClusterChooser(dir);
        
        messageinfo = CF.fitTheCurve(TL.convertBinaryToDecimal(messageValue));

        String messagePoints = CP.points(messageinfo, messageValue);

        String[] messageCartesianCoordinates = messagePoints.split(",");

        Iterator<String> message = messageinfo.iterator();
        
        String messageInfoToCluster = null;
        
        while (message.hasNext()) {
            String[] msg = message.next().split(":");
            messageInfoToCluster = msg[0];
        }
        
        String messageInfo = String.format(messageCartesianCoordinates[4] + "_" + messageCartesianCoordinates[5] + "_" + messageCartesianCoordinates[6] + "_" + messageInfoToCluster);
        CC.chooseCluster(messageInfo, originalMessage);
    }
}
