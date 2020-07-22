package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public WordCounter() {

    }

    public void count(String inputFile) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(inputFile));
        HashMap <String,Integer> wordCounter = new HashMap <String,Integer>();
        while (scan.hasNext())
        {
            String word = scan.next();
            word = word.replaceAll("[^a-zA-Z ]", "");
            if(wordCounter.containsKey(word))
            {
                wordCounter.put(word, wordCounter.get(word)+1);
            }
            else
            {
                wordCounter.put(word, 1);
            }
        }

        
              for (Map.Entry<String,Integer> print : wordCounter.entrySet())
              {
                  System.out.println(print.getKey()+" = "+print.getValue());
              }
           }
        
    }

