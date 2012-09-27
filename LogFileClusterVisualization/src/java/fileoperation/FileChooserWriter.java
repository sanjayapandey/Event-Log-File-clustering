/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author lnkhanal
 */
public class FileChooserWriter {

    private String parameters, orginalMessage, filePath;
    private float slopeTollerance = 3;
    private float lengthTollerance = 3;
    private float standardDeviationTollerance = 3;
    private float midPointTollerance = 3;

    public void  fileChooserWriter(String parameters, String originalMessage, String filePath) {
        this.parameters = parameters;
        this.orginalMessage = originalMessage;
        this.filePath = filePath;
    }

    public void chooseCluster() throws IOException {
        this.Cluster();
    }

    private void Cluster() throws IOException {
        int fileCount;

        String filename = String.format(this.parameters + ".txt");
        String[] messageInfo = this.parameters.split("_");

        File file = new File(this.filePath);

        if (file.isDirectory()) {
            String[] filesInTheDirectory = file.list();
            for (fileCount = 0; fileCount < filesInTheDirectory.length; fileCount++) {

                String[] clusterInfo = filesInTheDirectory[fileCount].split("_");
                clusterInfo[3] = clusterInfo[3].substring(0, clusterInfo[3].length() - 4);

                float lengthDifference = Math.abs(Float.parseFloat(messageInfo[0]) - Float.parseFloat(clusterInfo[0]));
                float standardDeviationDifference = Math.abs(Float.parseFloat(messageInfo[1]) - Float.parseFloat(clusterInfo[1]));
                float midPositionDifference = Math.abs(Float.parseFloat(messageInfo[2]) - Float.parseFloat(clusterInfo[2]));
                float slopDifference = Math.abs(Float.parseFloat(messageInfo[3]) - Float.parseFloat(clusterInfo[3]));

                if (lengthDifference <= lengthTollerance && standardDeviationDifference >= standardDeviationTollerance && slopDifference <= slopeTollerance && midPositionDifference <= midPointTollerance) {
                    filename = filesInTheDirectory[fileCount];
                    break;
                }
            }
        }
        java.io.FileWriter writeFile = new java.io.FileWriter("D:/Major/clusters/" + filename, true);
        BufferedWriter bf = new BufferedWriter(writeFile);
        bf.append(this.orginalMessage + "\n");
        bf.close();
        writeFile.close();
    }
}
