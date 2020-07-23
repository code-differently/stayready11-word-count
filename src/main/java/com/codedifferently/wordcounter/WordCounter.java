package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
     private HashMap<String,Integer> words;
     private ArrayList<String> wordOrder=new ArrayList<String>();

     public  WordCounter(String filePath){
         this.words=new HashMap<String, Integer>();
         Scanner file;
         try {
             file=new Scanner(new File(filePath));
             while(file.hasNext()){
                 String currentWord=file.next().toLowerCase().replaceAll("[!.?]","");
                 if(this.words.containsKey(currentWord)){
                     int newValue=this.words.get(currentWord)+1;
                     this.words.replace(currentWord,newValue);
                 }
                 else {
                     this.words.put(currentWord, 1);
                     this.wordOrder.add(currentWord);
                 }
             }
         } catch (FileNotFoundException e) {
             System.out.println(e.toString());
         }
     }

     public HashMap<String,Integer> getWords(){
         return this.words;
     }

     public String occurences(){
         String output="";
         for (String word:
         wordOrder){
             output+=String.format("%s occured %d time(s)\n",word,words.get(word));
         }
         return output.trim();
     }


     public String uniqueOccurences(){
         String output="";
         for (String word:
             wordOrder){
             if(words.get(word)==1)
                output+=String.format("%s occured %d time(s)\n",word,words.get(word));
         }
         return output.trim();

     }

     public String longestWord(){
        String longest="";
        for (String word:
            wordOrder){
            if(word.length()>longest.length())
                longest=word;
        }
        return longest;

    }

    public Integer wordCountOf(String word){
        if(words.containsKey(word))
            return words.get(word);

        return -1;
    }

    public String alphabeticalOrder(){
         String output="";
        TreeMap<String,Integer> sorted=new TreeMap<String, Integer>();
        sorted.putAll(words);
        for (Map.Entry<String,Integer> entry:
            sorted.entrySet()){
            output+=String.format("%s occured %d time(s)\n",entry.getKey(),entry.getValue());
        }
        return output.trim();
    }

    public String mostLeastWords(){
        String most="-Most used word(s)-\n";
        String least="-Least used word(s)-\n";
        double avgWordOccurence=0;
        for (Integer count :
             words.values()) {
            avgWordOccurence+=count;

        }
        avgWordOccurence/=words.size();
        for (String word:
            wordOrder){
            if(words.get(word)>=avgWordOccurence)
                most+=String.format("%s occured %d time(s)\n",word,words.get(word));
            else
                least+=String.format("%s occured %d time(s)\n",word,words.get(word));
        }
        return most+(least.trim());

    }
}
