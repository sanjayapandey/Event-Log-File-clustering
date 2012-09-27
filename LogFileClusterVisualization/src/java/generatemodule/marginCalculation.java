/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatemodule;

import sqlconnection.sqlConnection;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class marginCalculation {

    /*
     * The marginOfLog function returns the marginal value for take decision about accept word or reject it to take into model.
     * margin is different for different loglines.
     * for a logline, the margin is calculated as their individual frequency 
     * and determination of the mean, median. and other several mathematical calculations.
     */
    
    static private int margin = 0;
    
    static int marginOfLog(String lineOfLog) {
        try {
            //split line into individual words, it is done by space
            String[] word = lineOfLog.split("\\s{1,}");
            int noOfWord = word.length;
            int[] count = new int[noOfWord];



            //loop for all until word exists

            /*
             * for use probability(normal distribution) we should determine count of all words in logevent line, 
             * then replace all the words by ther count numbers 
             * then determine mean and standard deviation 
             * finally eveuate the marginal value using formula: marginal_value = percentage% * standard_deviation+mean
             */

            for (int i = 0; i < noOfWord; i++) {
                sqlConnection sql = new sqlConnection();
                ResultSet result_countWord = sql.ExecuteQuery("SELECT count,word from wordcollection where word = '" + word[i] + "'");
                while (result_countWord.next()) {
                    word[i] = result_countWord.getString("word");
                    count[i] = result_countWord.getInt("count");
                }
                //System.out.println("count is:"+count[i]);
            }
            /*
             * calculation of margin
             * we can get median and also standard deviation of the sequence from stat class 
             * use these to calculate the margin of the data(log count)
             */
            double mean = 0;
            double standardDev = 0;
            mean = Stat.caclMedian(count, noOfWord);
            standardDev = Stat.caclStanDev(count, noOfWord);
//            margin = (int) (-0.3 * standardDev + mean);
            margin = (int) (-0.1 * standardDev + mean);
//            System.out.println("meand and standard deviation is:"+mean + "and "+standardDev);

        } catch (Exception e) {
            System.err.println("error message:" + e.getMessage());
        }
        return margin;
    }
}
