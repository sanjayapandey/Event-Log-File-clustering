/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.io.DataInputStream;
import java.io.IOException;


/**
 *
 * @author lnkhanal
 */
public class readString {
        
    public String readMyString() throws IOException{
        DataInputStream input = new DataInputStream(System.in);
        System.out.println("Enter 'BYE' to terminate the program.");
        return (input.readLine());
    }
    
}
