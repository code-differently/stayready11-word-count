package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class WordCounter {//begin WordCounter

    private HashMap<String, Integer> map = new HashMap<>();
    private static final Logger log = Logger.getGlobal();
    private Scanner scan = new Scanner(System.in);
    private int uniqueWords = 0;

    public void createMap(File file){//begin createMap

       if(fileExists(file)){//begin if file exists
            //scan.useDelimiter("\r\n");
           while(scan.hasNextLine()) {//begin while file has next line

               String[] word = getLine(scan.nextLine());

               for (int i = 0; i < word.length; i++) {//begin for loop placing values in hash map
                   if (map.containsKey(word[i])) {
                       map.replace(word[i], map.get(word[i]) + 1);
                   }
                   else {
                       map.put(word[i], 1);
                       uniqueWords++;
                   }
               }//end for loop placing values in hash map
           }// end while file has next line
       }//end if file exists
        map.remove("");
    }//end createMap

    private String [] getLine(String input){
        input = input.toLowerCase();
        input = input.replaceAll("(?U)[\\p{S}\\p{P}]+", "");
        //log.info(input);
        String[] word = input.split(" ");
        return word;

    }

    private boolean fileExists(File file){
        try {
            scan = new Scanner(file);
            return true;
        }catch (FileNotFoundException e){
            log.info("File not found.");
            return false;
        }
    }

    public String getMostUsedWord(){

        String word = null;
        int max = 0;

        for(String s:map.keySet()){

            if(map.get(s) > max){
                max = map.get(s);
                word = s;
            }

        }
        return word;
    }

    public String getLeastUsedWord(){

        String word = null;
        int min = 9999;

        for(String s:map.keySet()){

            if(map.get(s) < min){
                min = map.get(s);
                word = s;
            }

        }
        return word;
    }

    public String getLongestWord(){

        String word = null;
        int max = 0;

        for(String s: map.keySet()){

            if(s.length() > max){
                max = s.length();
                word = s;
            }

        }
        return word;
    }

    public int getWordCount(String str){
        try{
            return map.get(str);
        }catch(NullPointerException e){
            log.info("Word does not exist within file.");
        }
        return 0;
    }

    public int getUniqueWords(){
        return uniqueWords;
    }

    public String getMap(){

        Object[] arr =  map.keySet().toArray();
        Arrays.sort(arr);
        String mapValues = "";
        mapValues+="[";
        for (int i = 0; i < arr.length; i++){
            mapValues+=arr[i] + " (Seen " + map.get(arr[i]) + ")";
            if(i<arr.length-1){
                mapValues+=", ";
            }else{
                mapValues+="]";
            }
        }
        return mapValues;
    }

    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        log.info("Enter a file: ");
        File file = new File(scan.nextLine());
        WordCounter wc = new WordCounter();

        wc.createMap(file);
        log.info(wc.getMap());
        log.info("Unique Words Count: "+wc.getUniqueWords());
        log.info("Most used word: "+wc.getMostUsedWord());
        log.info("Least used word: "+wc.getLeastUsedWord());
        log.info("Longest word: "+wc.getLongestWord());
        log.info("Enter a word to look at: ");
        String word = scan.nextLine();
        log.info("Word Count of " +word.toLowerCase() + ": " +wc.getWordCount(word.toLowerCase()));


    }
}//end WordCounter
