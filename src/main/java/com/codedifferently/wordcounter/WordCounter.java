package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
    Map<String, Integer> map = new HashMap<>();
    private String filePath;
    File file;
    Scanner in;

    public static void main(String[] args) throws Exception {
        WordCounter obj = new WordCounter();
        obj.askFilePath();
        obj.createFile();
        obj.storeWords();
        obj.uniqueWordCount();
        obj.showUniqueWordsAlphabetical();
        obj.mostUsedWord();
        obj.leastUsedWord();
        obj.longestWord();
        obj.returnCountOfString();
    }

    public String getFilePath() {
        return filePath;
    }

    // setter is used in the askFilePath method
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // takes user input and sets the file path to it
    public void askFilePath() {
        System.out.println("What is the file path to the document?");
        in = new Scanner(System.in);
        setFilePath(in.next());
    }

    // creates a new File object based on the filepath
    public File createFile() {
        this.file = new File(filePath);
        return file;
    }

    // Reads in the words and stores in a hashmap
    public void storeWords() throws FileNotFoundException {
        in = new Scanner(createFile());
        // reads line by line
        while(in.hasNextLine()) {
            String currentLine = in.nextLine();
            // removes anything that isn't a letter or a space
            currentLine = currentLine.replaceAll("[^a-zA-Z ]", "");
            currentLine = currentLine.toLowerCase();
            // separates each line into a word array
            String[] words = currentLine.split(" ");
            // iterating through words
            for (String string : words) {
                if (map.containsKey(string)) {
                    map.put(string, map.get(string) + 1);
                } else {
                    map.put(string, 1);
                }
            }
        }
    }

    // shows unique words in alphabetical order by using treemap
    public void showUniqueWordsAlphabetical() {
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + "\tCount: " + entry.getValue());
        }
    }

    // returns unique word count
    public int uniqueWordCount() {
        return map.size();
    }

    // returns most used word
    public String mostUsedWord() {
        int mostUsedWordCount = 1;
        String mostUsedWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mostUsedWordCount) {
                mostUsedWord = entry.getKey();
                mostUsedWordCount = entry.getValue();
            } else if(entry.getValue() == mostUsedWordCount) {
                mostUsedWord += ", " + entry.getKey();
            }
        }
        return mostUsedWord;
    }

    // returns least used word
    public String leastUsedWord() {
        int leastUsedWordCount = Integer.MAX_VALUE;
        String leastUsedWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < leastUsedWordCount) {
                leastUsedWord = entry.getKey();
                leastUsedWordCount = entry.getValue();
            } else if(entry.getValue() == leastUsedWordCount) {
                leastUsedWord += ", " + entry.getKey();
            }
        }
        return leastUsedWord;
    }

    // returns longest word
    public String longestWord() {
        int longestWordLength = 0;
        String longestWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().length() > longestWordLength) {
                longestWord = entry.getKey();
                longestWordLength = entry.getKey().length();
            } else if(entry.getValue() == longestWordLength) {
                longestWord += ", " + entry.getKey();
            }
        }
        return longestWord;
    }

    // returns the count of the word chosen by the user
    public int returnCountOfString() {
        in = new Scanner(System.in);
        System.out.println("What word would you like to check?");
        String key = in.next();
        if (map.containsKey(key)) {
            System.out.println("Word exists..Word Count: " + map.get(key));
            return map.get(key);
        } else {
            System.out.println("Word does not exists");
            return 0;
        }
    }


}
