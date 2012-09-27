package streamingLogHandle;

import generatemodule.ClassScanner;
import generatemodule.WordVeryfier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import main.ClusterProcessor;

public class LogHandller {

    ClusterRecommender recommender = new ClusterRecommender();
    LineManupulator manupulate = new LineManupulator();
    ClusterProcessor clusterprocess = new ClusterProcessor();

    public boolean process() {
        String directory = "D:/Major/DumpLogs";
        return(this.fileProcess(directory, new ClassScanner(), new WordVeryfier()));
    }

    private boolean fileProcess(String directory, ClassScanner scanner, WordVeryfier verify) {
        boolean returnFlag = false;
        try {
            String logDirectory;
            String logline;
            String fileDirectory = directory;
            Scanner scan;
            File f1 = new File(fileDirectory);

            if (f1.isDirectory()) {
                String s[] = f1.list();

                for (int i = 0; i < s.length; i++) {

                    logDirectory = fileDirectory + '/' + s[i];//sets the path of the multiple log files in the given directory.
                    scan = scanner.scannerFunction(logDirectory);
                    while (scan.hasNextLine()) {
                        String orginalLogLine = scan.nextLine();
                        logline = verify.parseAll(orginalLogLine);

                        manupulate.setlogLine(logline);
                        manupulate.patternGenerator();
                        recommender.reCommendation(manupulate.getnewLogLine(), logline);
                        clusterprocess.decide(recommender.getBinary(),orginalLogLine);
                    }
                }
                returnFlag = true;
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException e) {
            System.err.println(e);
        }
        return returnFlag;
    }
}
