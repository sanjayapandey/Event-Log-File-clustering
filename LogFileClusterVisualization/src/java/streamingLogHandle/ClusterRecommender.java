/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamingLogHandle;

import clusterCreator.LogLineRepresentor;
import javax.naming.BinaryRefAddr;

/**
 *
 * @author DELL
 */
public class ClusterRecommender extends LineManupulator {
    private String binReprentation;
    public void reCommendation(String logLine , String orginalLine){
        
        LogLineRepresentor representer = new LogLineRepresentor();
        binReprentation = representer.binaryRepresentationOfLogLine(logLine);
//        System.out.println("orginal: "+orginalLine+"\nParsed:"+logLine+"\nRepresentation:"+binReprentation+"\n\n");
    }
    public String getBinary(){
        return binReprentation;
    }
}
