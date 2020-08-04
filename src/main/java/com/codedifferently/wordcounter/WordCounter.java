package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter 
{
 
    LinkedHashMap <String,Integer> wordCounter = new LinkedHashMap <String,Integer>();
    public WordCounter() 
    {

    }

    public void count(String inputFile) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(inputFile));
       wordCounter.clear();
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

                //To print each element in wordCounter on seperate lines
              for (Map.Entry<String,Integer> print : wordCounter.entrySet())
              {
                  System.out.println(print.getKey()+" = "+print.getValue());
              }
           }

           public String getWord(String input)
           {
                if (wordCounter.size() == 0)
                {
                    System.out.println("wordCounter is empty use count method first");
                }
                else
                {
                for (int i = 0; i < wordCounter.size();i++)
                {
                    if (wordCounter.containsKey(input))
                    {
                       return  input+" Appears "+wordCounter.get(input).intValue();

                    }
                }
            }
            return input;
        }
        
    }

