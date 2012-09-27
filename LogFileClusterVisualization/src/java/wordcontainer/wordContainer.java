/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcontainer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnkhanal
 */
public class wordContainer {

    public int dData = 0;
    public wordContainer next;
    public wordContainer first;               // ref to first link
    private wordContainer last;
    public String word = "";
    // next link in list
// -------------------------------------------------------------

    public wordContainer(int d, String my_word) // constructor
    {
        dData = d;
        first = null;                  // no links on list yet
        last = null;
        word = my_word;
    }
// -------------------------------------------------------------

    public int displayLink() // display this link
    {
        //Have to edit this method to display the lis contents.
        System.out.print("The container has the following data:\n ");
        wordContainer current = first;       // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
        return 0;
    }
    // end class Link
////////////////////////////////////////////////////////////////
    // ref to last link

    public boolean isEmpty() // true if no links
    {
        return first == null;
    }
// -------------------------------------------------------------

    public void insertFirst(int dd, String word) // insert at front of list
    {
        wordContainer newLink = new wordContainer(dd, word);
        //System.out.println("Inserting to the datastructure.");
        if (isEmpty()) // if empty list,
        {
            last = newLink;             // newLink <-- last
        }
        newLink.next = first;          // newLink --> old first
        first = newLink;

    }

    public int deleteFirst() // delete first link
    {                              // (assumes non-empty list)
        int temp = first.dData;
        if (first.next == null) // if only one item   
        {
            last = null;                // null <-- last
        }
        first = first.next;            // first --> old next
        return temp;
    }


    public void displayList() {

        wordContainer current = first;          // start at beginning
        while (current != null) // until end of list,
        {
            //Later word and the count both should be returned as a single bundle.
            // System.out.println(current.word + "\t::" + current.dData);      // print data
            current = current.next;     // move to next link
        }
        System.out.println("\n");
    }

    public void searchList(String searchString) {
        wordContainer current = first;
        wordContainer dummy = first;
        //check for the first item
        if (isEmpty()) {
            insertFirst(1, searchString);
            return;
        } else {
            while (current.next != null) {
                if (searchString.equals(current.word)) {
                    current.dData += 1;
                    first = dummy;
                    return;

                } else {
                    current = current.next;
                }
            }

        }
        if (searchString.equals(current.word)) {
            current.dData += 1;
            first = dummy;
            return;

        } else {
            wordContainer temp = new wordContainer(1, searchString);
            current.next = temp;
            temp.next = null;
            first = dummy;
            return;
        }



    }
    public boolean isThereThisWord(String str){
        wordContainer dummy = first;
        wordContainer current = first;
        while(current != null){
            if(current.next == null){
                if(current.word.equals(str)){
                     first = dummy;
                    return true;
                }
            }
            if(current.word.equals(str)){
                first = dummy;
                return true;
            }
            
            current = current.next;
        }
        return false;
    }

    public float calculateMean() {
        float mean = 0;
        wordContainer dummy = first;
        wordContainer current = first;
        int count = 0;
        int totalWords = 0;

        //Willing to count until the last element is found
        while (current != null) {
            totalWords += current.dData;
            count += 1;
            current = current.next;

        }
        mean = totalWords / count;
        first = dummy;
        return mean;
    }

    public float calculateStandardDeviation() {
        float sd = 0;
        wordContainer dummy = first;
        wordContainer current = first;
        int count = 0;
        float mean = calculateMean();
        long squareOfWordCount = 0;
        while (current != null) {
            squareOfWordCount += Math.pow((current.dData - mean), 2);
            // System.out.println("Current data:"+current.dData+"\nMean"+mean);
            count += 1;
            current = current.next;

        }
        System.out.println("Count" + count + "\nSquare:" + squareOfWordCount);
        sd = (float) Math.pow(squareOfWordCount / count, 0.5);
        first = dummy;
        return sd;
    }

    public void pushWordToBag() {
        wordContainer dummy = first;
        wordContainer current = first;
        float mean = calculateMean();
        while (current != null) {
            if (current.dData >= mean) {
                try {
                    FileWriter file = new FileWriter("D:/Major/WordBag/bag.txt", true);
                    BufferedWriter bf = new BufferedWriter(file);
                    bf.append(current.word+"\n");
                    bf.close();
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(wordContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            current = current.next;
        }
        first = dummy;
    }
}
