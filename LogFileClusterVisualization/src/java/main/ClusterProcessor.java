/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import fileoperation.FileChooserWriter;
import fixbits.BitFixer;
import java.io.IOException;
import statisticalanalysis.CurveFitter;
import statisticalanalysis.ParameterComputer;
import statisticalanalysis.PointsFixer;

/**
 *
 * @author lnkhanal
 */
public class ClusterProcessor {

    String dir = "D:/Major/clusters/";
    ParameterComputer parametercomputer = new ParameterComputer();
    fileoperation.FileChooserWriter filewriter = new FileChooserWriter();
    BitFixer bitsfixer = new BitFixer();
    PointsFixer pointfixer = new PointsFixer();
    CurveFitter curvefitter = new CurveFitter();

    public void decide(String message, String originalMessage) throws IOException {


        bitsfixer.bitFixer(message);
        bitsfixer.fixBits();
        message = bitsfixer.getVal();

        pointfixer.pointsFixer(message);
        pointfixer.fixpoints();

        curvefitter.curveFitter(pointfixer.getVal());
        curvefitter.fitTheCurve();
        String[] slopeintercept = curvefitter.getVal().split(":");

        parametercomputer.parameterComputer(curvefitter.getVal(), message);
        parametercomputer.computeParameters();
        String[] messageCartesianCoordinates = parametercomputer.getVal().split(",");

        String messageInfo = String.format(messageCartesianCoordinates[4] + "_" + messageCartesianCoordinates[5] + "_" + messageCartesianCoordinates[6] + "_" + slopeintercept[0]);
        filewriter.fileChooserWriter(messageInfo, originalMessage, dir);
        filewriter.chooseCluster();


    }
}
