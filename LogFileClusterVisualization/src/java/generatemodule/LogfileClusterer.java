/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatemodule;
import java.io.IOException;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class LogfileClusterer {
static private String fileDirectory = "D:/Major/DumpLogs";

    public static void main(String[] args) throws SQLException {
       try {
        LogModuleCreator createLogModule = new LogModuleCreator(fileDirectory);
        PatternFileGenerator patternFileGeneratorObject = new PatternFileGenerator();
        
            createLogModule.fillDatabaseFirstPass();
            createLogModule.createModuleSecondPass();
         
            patternFileGeneratorObject.patternFileGenerator();
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
