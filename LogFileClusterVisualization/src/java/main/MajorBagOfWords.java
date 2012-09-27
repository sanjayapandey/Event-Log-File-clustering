/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import streamingLogHandle.LogHandller;

/**
 * The class with main method. This class controls all the activities of the program.
 * @author lnkhanal
 */
public class MajorBagOfWords {

    /**
     * @param args the command line arguments
     */
    public boolean mainMethod() throws IOException {
        boolean returnFlag = false;
        LogHandller logHandeller = new LogHandller();
        if(logHandeller.process()){
            returnFlag = true;
        }
        return returnFlag;
//        String dir = "D:/Major/clusters/";
//
//        
//        String message = "1100010100000111011010101010001110";
//
//        BitFixer bitsfixer = new BitFixer(message);
//        bitsfixer.fixBits();
//        message = bitsfixer.getVal();
//
//        PointsFixer pointfixer = new PointsFixer(message);
//        pointfixer.fixpoints();
//
//        CurveFitter curvefitter = new CurveFitter(pointfixer.getVal());
//        curvefitter.fitTheCurve();
//        String[] slopeintercept = curvefitter.getVal().split(":");
//
//        ParameterComputer parametercomputer = new ParameterComputer(curvefitter.getVal(), message);
//        parametercomputer.computeParameters();
//        String[] messageCartesianCoordinates = parametercomputer.getVal().split(",");
//
//        String messageInfo = String.format(messageCartesianCoordinates[4] + "_" + messageCartesianCoordinates[5] + "_" + messageCartesianCoordinates[6] + "_" + slopeintercept[0]);
//        fileoperation.FileChooserWriter filewriter = new FileChooserWriter(messageInfo, message, dir);
//        filewriter.chooseCluster();
//
//
//        System.out.println("Message: (x1,y1) = (" + messageCartesianCoordinates[0] + "," + messageCartesianCoordinates[1] + ")" + " & (x2,y2) = (" + messageCartesianCoordinates[2] + "," + messageCartesianCoordinates[3] + ")");
//        System.out.println("Length of thus Message line: " + messageCartesianCoordinates[4]);
//        System.out.println("Mid position of the line formed[Message]: " + messageCartesianCoordinates[6]);
//        System.out.println("Standard deviation of the points in the string of[Message]: " + Float.parseFloat(messageCartesianCoordinates[5]));
        

    }
   
}
