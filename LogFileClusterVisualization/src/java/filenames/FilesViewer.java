/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filenames;

import java.io.File;

/**
 *
 * @author user
 */
public class FilesViewer {

    String filePath = "D:/Major/clusters/", cluster = "Cluster-";

    public String showFileNames() {
        String returnString = "";


        File file = new File(filePath);

        if (file.isDirectory()) {
            String[] filesInTheDirectory = file.list();
            int count = 1;
            for (int fileCount = 0; fileCount < filesInTheDirectory.length; fileCount++) {

//                filename and the variable name are concatinated with the comma and individual info are concatinated with the asterick.
                returnString = returnString + String.format(cluster + count + "," + filesInTheDirectory[fileCount] + ":");
                count++;

            }
        }
        return returnString;

    }
}
