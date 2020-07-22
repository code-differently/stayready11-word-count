package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {

    private final HashMap<String, Integer> wordOccurs = new HashMap<>(); // Store words and occurrences of each
    private int uniqueWords = 0;
    private File file; // File being read
    private Scanner input; // Reads file
    private final FileScanner fs = new FileScanner();

    public WordCounter() {}

    public WordCounter(File f) {
        this.file = f;
        input = fs.newFileScanner(file);
    }

    public File getFile() {
        return file;
    }

    public HashMap<String, Integer> getWordOccurs() {
        return wordOccurs;
    }

    public int getUniqueWords() {
        return uniqueWords;
    }

    public void setFile(File f) {
        file = f;
        input = fs.newFileScanner(file);
        wordOccurs.clear();
        uniqueWords = 0;
    }

    // Read file and put unique words in map with occurrences
    public void readFileWords() {
        while(input.hasNext()) {
            String current = input.next().toUpperCase();
            if(!wordOccurs.containsKey(current)) {
                wordOccurs.put(current, 1);
                uniqueWords++;
            }
            else
                wordOccurs.replace(current, wordOccurs.get(current) + 1);
        }
    }

    // Get all words and how many times they occur (In alphabetical order)
    public String wordsAndOccurrences() {
        TreeMap<String, Integer> sorted = new TreeMap<>(wordOccurs);
        StringBuilder ret = new StringBuilder();
        for(HashMap.Entry<String, Integer> entry : sorted.entrySet()) {
            ret.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return ret.toString().trim();
    }

    // Return the amount of times a specific word occurs
    public int getOccurrences(String word) {
        String wordIC = word.toUpperCase();
        if(wordOccurs.containsKey(wordIC))
            return wordOccurs.get(wordIC);
        return 0;
    }

    // Get most used word(s)
    public String mostUsed() {
        StringBuilder mostUsedWord = new StringBuilder();
        int most = 0;
        for(Map.Entry<String, Integer> entry : wordOccurs.entrySet()) {
            if(entry.getValue() > most) {
                mostUsedWord = new StringBuilder(entry.getKey());
                most = entry.getValue();
            } else if(entry.getValue() == most) {
                mostUsedWord.append(", ").append(entry.getKey());
            }
        }
        return mostUsedWord + " (" + most + ")";
    }

    // Get least used word(s)
    public String leastUsed() {
        StringBuilder leastUsedWord = new StringBuilder();
        int least = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : wordOccurs.entrySet()) {
            if(entry.getValue() < least) {
                leastUsedWord = new StringBuilder(entry.getKey());
                least = entry.getValue();
            } else if(entry.getValue() == least) {
                leastUsedWord.append(", ").append(entry.getKey());
            }
        }
        return leastUsedWord + " (" + least + ")";
    }

    public String longestWord() {
        StringBuilder longestWord = new StringBuilder();
        int longest = 0;
        for(Map.Entry<String, Integer> entry : wordOccurs.entrySet()) {
            if(entry.getKey().length() > longest) {
                longestWord = new StringBuilder(entry.getKey());
                longest = entry.getKey().length();
            } else if(entry.getKey().length() == longest) {
                longestWord.append(", ").append(entry.getKey());
            }
        }
        return longestWord + " (" + longest + " characters)";
    }

}

class FileScanner {
    Scanner in = new Scanner(System.in);
    public Scanner newFileScanner(File file) {
        Scanner ret = new Scanner(System.in);
        File newF = file;
        boolean passed = false;
        while(!passed)
        try {
            ret = new Scanner(newF);
            passed = true;
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Enter existing file: ");
            newF = new File(in.nextLine());
        }
        return ret;
    }
}
