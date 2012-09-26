/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterlogcount;

import inserttothecluster.FileRead;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnkhanal
 */
public class ClusterLogCounter {

    public String countClusterLog() {
        
        String returnString, filePath = "D:/Major/clusters/";
        int fileCount = 0, messageCount = 0;
        File file = new File(filePath);

        if (file.isDirectory()) {
            String[] filesInTheDirectory = file.list();
            for (fileCount = 0; fileCount < filesInTheDirectory.length; fileCount++) {
                try {
                    FileInputStream inputFile = new FileInputStream(filePath + filesInTheDirectory[fileCount]);
                    DataInputStream ds = new DataInputStream(inputFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(ds));
                    try {
                        while ((br.readLine()) != null) {
                            messageCount++;
                        }
                        br.close();
                        ds.close();
                        inputFile.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
        returnString = String.format(messageCount + ":" + fileCount);
        return returnString;
    }
}
