package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public void addToMap(File fileName)throws FileNotFoundException{

        try{
            Scanner scan = new Scanner(fileName);

            while(scan.hasNextLine()){
                String currentLine = scan.nextLine();
                String[] words = currentLine.split(" ");

                for(String w: words){
                    w = w.replaceAll("\\p{Punct}", "");

                    if(map.containsKey(w)){
                        int occurrences = map.get(w);
                        occurrences++;
                        map.put(w, occurrences);
                    }
                    else
                        map.put(w, 1);
                }
            }
            scan.close();
            System.out.println(map.entrySet());
        }
        catch(FileNotFoundException e){
            System.out.println("The file was not found.");
            e.printStackTrace();
        }
    }

    protected HashMap<String, Integer> getMap(){
        return map;
    }

    public int uniqueWordCount(){
        Set<String> set = map.keySet();
        return set.size();
    } 

    public String mostUsedWord(){

        int most = 1;
        String mostUsed = "";

        Set<String> set = map.keySet();
        for(String word: set){
            if(map.get(word) > most){
                mostUsed = word;
                most = map.get(word);
            }
        }

        return mostUsed;
    }

    public String leastUsedWord(){
        int least = 2;
        String leastUsed = "";

        Set<String> set = map.keySet();
        for(String word: set){
            if(map.get(word) < least){
                leastUsed = word;
                least = map.get(word);
            }
        }

        return leastUsed;
    }

    public String longestWord(){
        String longest = "";
        int longestSize = 0;

        Set<String> set = map.keySet();
        for(String word: set){
            if(word.length() > longestSize){
                longest = word;
                longestSize = word.length();
            }
        }

        return longest;
    } 

    public int getWordCount(String word){
        if(!(map.containsKey(word)))
            return 0;
            
        return map.get(word);
    }

    public boolean checkFileName(String file){
        String sub = file.substring(file.length() - 4);

        if(sub.equals(".txt"))
            return true;
        
        return false;
    }
}

 