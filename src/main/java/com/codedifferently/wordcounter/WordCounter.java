package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class WordCounter {

    private final HashMap<String, Integer> myMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws FileNotFoundException{



    }



    public static String wordCount() throws FileNotFoundException{
        String empString = "";
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        File file2 = new File("C:\\Users\\KingCelliss\\dev\\stayready11-word-count\\anime.txt");
        Scanner words = new Scanner(file2);

        while (words.hasNext()){
            String upcomingWords = words.nextLine();
            upcomingWords = upcomingWords.replaceAll("[^a-zA-Z]", "");
            upcomingWords = upcomingWords.toLowerCase();
            String[] stringArr = upcomingWords.split(" ");

            for (String word: stringArr) {
                if (myMap.get(word) != null){
                    myMap.put(word, myMap.get(word) + 1);
                }
                else {
                    myMap.put(word, 1);
                }
            }
        }
        Set<String> wordsInMap = myMap.keySet();
        for (String elements : wordsInMap) {
            empString += elements + " " + "(Seen " + myMap.get(elements) + ")\n";
        }
        return empString;
    }

    public static Boolean findWord(String search) throws FileNotFoundException {
        wordCount();
        if (wordCount().equalsIgnoreCase(search)){
            return true;
        }
       return false;
    }

}
