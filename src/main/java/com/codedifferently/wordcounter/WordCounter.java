package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class WordCounter {
  Map<String, Integer> map = new TreeMap<String, Integer>();
  Scanner input; 
  File file; 

  public WordCounter(){

  }
  public String[] processWords(String s){
    //converting all of the characters in the string to lowerCase:
    s = s.toLowerCase();
    //removing all special characters from the string:
    s = s.replaceAll("(?U)[\\p{S}\\p{P}]+","" );
    //create array and split 
    String[] words = s.split(" "); 

    return words;
  }

  public void addFileToMap(File file) throws FileNotFoundException{
    input = new Scanner(file);
    //while the there are still words int the text file:
    while(input.hasNext()){
      String[] words = processWords(input.next()); //extracting the words
      //adding the words to the map
      for (int i = 0 ; i < words.length; i++){
        if(map.containsKey(words[i])){
          map.put(words[i], map.get(words[i]) + 1); 
        } else {
          map.put(words[i], 1);
        }
      }
    }

  }

  public Map<String, Integer> addFileToMapTester(File file) throws FileNotFoundException{
    input = new Scanner(file);
    //while the there are still words int the text file:
    while(input.hasNext()){
      String[] words = processWords(input.next()); //extracting the words
      //adding the words to the map
      for (int i = 0 ; i < words.length; i++){
        if(map.containsKey(words[i])){
          map.put(words[i], map.get(words[i]) + 1); 
        } else {
          map.put(words[i], 1);
        }
      }
  }
  return map;

  }

  //display map in alphabetical order: 
  //treeMaps are sorted according to the natural order of its keys
  //thus, just print all in the set
  public String displayAlphabetical(){
    String s = "";
    for(Entry<String, Integer> entry : map.entrySet()){
      System.out.println(entry.getKey());
      s += " " + entry.getKey();
    }
    return s;
  }

  //display the count the unique words in the map
  public int displayCountOfUnique(){
    int counter = 0;

    for(Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() == 1){
        counter++;
      }
    }
    System.out.println("There are " + counter + " unique words");
    return counter;
  }

  //display the most used word
  public String displayMostUsedWord(){
    int max = Integer.MIN_VALUE; 
    String mostUsed = "";
    for(Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() > max){
        max = entry.getValue(); 
        mostUsed = entry.getKey();
      } else if(entry.getValue() == max){
        mostUsed += ", "+ entry.getKey();
      }
    }

    System.out.println("The most used word is " + mostUsed);
    return mostUsed;

  }

  //display the least used word
  public String displayLeastUsedWord(){
    int min = Integer.MAX_VALUE;
    String leastUsed = "";
    for(Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() < min){
        min = entry.getValue(); 
        leastUsed = entry.getKey();
      } else if(entry.getValue() == min){
        leastUsed += ", "+ entry.getKey();
      }
    }

    System.out.println("The least word(s): " + leastUsed);
    return leastUsed;
  }

  //display longest word in map
  public String displayLongestWord(){
    String longest = "";
    int max = Integer.MIN_VALUE; 

    for(String word: map.keySet()){
      if(word.length() > max){
        max = word.length();
        longest = word;
      } else if (word.length() == max){
        longest += ", " + word;
      }
    }
    System.out.println("The longest word(s): " + longest);
    return longest; 
  }

  //display count of the word in file
  public int displayWordCount(String str) throws NullPointerException{
    System.out.println(map.get(str)); 
    return map.get(str); 
  }

  //create main method that interacts with the user
  public File getFile(){
    input = new Scanner(System.in); 
    System.out.println("Enter a File: ");
    File file = new File(input.nextLine());
    return file;
  }

  public void printMap(){
    for(Entry<String, Integer> entry: map.entrySet()){
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  public void wordCounterDisplay(){
    input = new Scanner(System.in);
    System.out.println("Enter a word to search it's value: ");
    displayWordCount((input.next()).toLowerCase());
  }


  public static void main(String[] args) throws FileNotFoundException {
    //because main method is static:
    WordCounter wc = new WordCounter();
    File file = wc.getFile(); 

    //add file to map
    wc.addFileToMap(file);
    wc.printMap();
    System.out.println("_________________________________________________ \n");
    wc.displayAlphabetical();
    System.out.println("_________________________________________________ \n");
    wc.displayCountOfUnique();
    System.out.println("_________________________________________________ \n");
    wc.displayLeastUsedWord();
    System.out.println("_________________________________________________ \n");
    wc.displayMostUsedWord(); 
    System.out.println("_________________________________________________ \n");
    wc.displayLongestWord();
    System.out.println("_________________________________________________ \n");
    wc.wordCounterDisplay();

  

  }


  
}
