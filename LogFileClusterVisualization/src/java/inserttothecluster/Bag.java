/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnkhanal
 */
public class Bag {

    public wordContainer makeABag() {
        wordContainer wordcontainer = new wordContainer(0, "");
        try {
            FileReader file = new FileReader("D:/Major/WordBag/bag.txt");
            BufferedReader bf = new BufferedReader(file);
            String words = "";

            try {
                while ((words = bf.readLine()) != null) {
                    wordcontainer.searchList(words);
                }
                bf.close();
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Bag.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wordcontainer;
    }
}
