package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {

    File file;

    private HashMap<String , Integer> hashMap = new HashMap<String,Integer>();
    
    public void counting(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String sentence = scan.nextLine();
            String[] words = sentence.split(" ");
            for(String w: words){
                w = w.replaceAll("[\\W]", "");
                if(hashMap.containsKey(w)) {
                    Integer occurrences = hashMap.get(w)+1;
                    hashMap.put(w, occurrences);
                }else {
                hashMap.put(w, 1);
                }
            }
            
        }scan.close();
    }

  public String alphabeticalOrder(){
      String alphaOrder = "";
      ArrayList<String> sorted = new ArrayList<String>(hashMap.keySet());
      Collections.sort(sorted);
      for (String word : sorted) 
      {
              alphaOrder += word + "Appeared:" + hashMap.get(word);
      }
      return alphaOrder; 

  }
    

     public Integer wordCount(String word) {
         if(!hashMap.containsKey(word)) {
             return 0;
         }
         return hashMap.get(word);
     }
 

    public String mostFrequency(){ 
        String most = "";
        String message = "The most used word is: ";
        Integer highestFreq = 0;  //1
        
        for (String word : hashMap.keySet()) {
            if(hashMap.get(word) > highestFreq){
                most = word;
                highestFreq = hashMap.get(word);
            }    

        }
            return message + most;
    }
    public String leastFrequency(){ 
        String least = "";
        String message = "The least used word is: ";
        Integer leastFreq = 2; 
        for (String word : hashMap.keySet()) {
            if (hashMap.get(word) < leastFreq) {
                least = word;
                leastFreq = hashMap.get(word);
            }    
        }
        return message + least;
    }

    public Integer uniqueWords(){
        /**
         * Set<String> set = map.keySet();
         * return hashMap.size();
         */
        Integer count = 0; 

        for (String key : hashMap.keySet()) {
            if (hashMap.containsValue(1)) {
                count++;    
            }
        }

        return count;
    }

    public String longestWord(){ 
        String longW = "";
        String message = "The longest word is: ";
        Integer longest = 0; 
        for (String word : hashMap.keySet()) {
            if (word.length() > longest) {
                longW = word;
                longest = word.length();
            }    
        }
        return message + longW;
    }
}
