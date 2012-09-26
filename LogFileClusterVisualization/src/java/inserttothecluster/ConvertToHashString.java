/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

/**
 *
 * @author lnkhanal
 */
public class ConvertToHashString {

    public String ConvertMe(wordContainer words, String str) {
        String returnString = "";
        final String REGEX = "[\\s\\<\\>\\@\\-~`#+/*\\(\\t\\,[ :]|[: ]){}\\[\\]'=^;!_%]+";

        str = str.replaceAll(REGEX, " ");
        String[] splitstring = str.split(" ");

        for (int i = 0; i < splitstring.length; i++) {
            if (words.isThereThisWord(splitstring[i])) {
                returnString += splitstring[i] + " ";
                System.out.println(i + 1 + ".  Sub-string: " + splitstring[i]);
            }
        }
        return returnString;
    }
}
