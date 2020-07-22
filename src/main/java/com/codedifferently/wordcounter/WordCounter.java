package com.codedifferently.wordcounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    public static void main (String[] args){

        Map<String, Integer> wordMap = new HashMap<String,Integer>();

        String text = FileReader.readFile();

        String [] words = text.split(" ");

        //System.out.println(Arrays.toString(words));

        for(String word: words){

            if (!wordMap.containsKey(word) && !word.trim().isEmpty()){ //if this is a new word that isn't a space
                wordMap.put(word, 1);

            }else if (wordMap.containsKey(word) && !word.trim().isEmpty()){ //Used word and not white space

                wordMap.replace(word, wordMap.get(word) + 1); //increment value
            }

        }

        //printMap(wordMap);

        sortMap(wordMap);

        getMostLeast(wordMap);

        



    }

    public static String printMap(Map<String,Integer> wordMap){

        String msg = "";

        for (Map.Entry<String,Integer> entry : wordMap.entrySet()) {
            msg += (entry.getKey() + " (Seen " + entry.getValue() + ")\n");
        }

        System.out.println(msg);
        return msg;

    }

    public static String sortMap(Map<String,Integer> wordMap){

        String msg = "";

        List<String> sortedKeys = new ArrayList<String>(wordMap.keySet());

        Collections.sort(sortedKeys);
        //Collections.reverse(sortedKeys);

        for (String word : sortedKeys) {
            msg += (word + " (Seen " + wordMap.get(word) + ")\n");
        }

        System.out.println(msg);
        return msg;

    }

    public static void getMostLeast(Map<String,Integer> wordMap){

        String mostWord = "nothing";
        String leastWord = "nothing";

        int mostFreq = 0;
        int leastFreq = 1;

        for (String key : wordMap.keySet()) {

            if (wordMap.get(key) > mostFreq){

                mostWord = key;
                mostFreq = wordMap.get(key);

            }

            else if(wordMap.get(key) <= leastFreq){
                leastWord = key;
                leastFreq = wordMap.get(key);;

            }

        }

        String msg = "The most redundant word is: " + mostWord + ", appearing " + mostFreq + " times.\n" +
                     "The least redundant word is: " + leastWord + ", appearing " + leastFreq + " times.\n";



        System.out.println(msg);


    }
}
