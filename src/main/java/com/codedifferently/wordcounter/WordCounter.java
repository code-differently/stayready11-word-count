package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.*;

import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordCounter {
    //sorts the words alphabetically
    static TreeMap<String, Integer> trackUniqueWords = new TreeMap<String, Integer>();
    //static to prevent garbage collection
    private final static Logger myLogger = Logger.getLogger("com.codedifferently.wordcounter");

    public static void main(String[] args) {
        File file = new File("C:\\Kaveesha\\Github\\devCodeDifferently\\stayReadyLabs\\stayready11-word-count\\TheModernPrometheus.txt");
        readFile(file);
        printValuesInHashMap();
        myLogger.info(getMostOrLeastUsedWords("most"));
        myLogger.info(getMostOrLeastUsedWords("least"));
        myLogger.info(longestWords());
    }

    public static void readFile(File file) {
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            while(in.hasNext()) {
                String individualWord = in.next().toLowerCase();
                individualWord = individualWord.replaceAll("[^a-z]", "");
                incrementOrPlaceValueInHashMap(individualWord);
            }
        }
        catch(FileNotFoundException fileNotFoundException) {
            myLogger.severe("File cannot be found. Try again another time.");
            fileNotFoundException.printStackTrace();
        }
    }

    private static void incrementOrPlaceValueInHashMap(String individualWord) {
        if(trackUniqueWords.containsKey(individualWord)) {
            trackUniqueWords.put(individualWord, trackUniqueWords.get(individualWord) + 1);
        }
        else {
            trackUniqueWords.put(individualWord, 1);
        }
    }

    private static void printValuesInHashMap() {
        for(Map.Entry<String, Integer> word: trackUniqueWords.entrySet()) {
            myLogger.info(word.getKey() + " occurs " + word.getValue() + " times.");
        }
    }

    public static String getMostOrLeastUsedWords(String mostOrLeast) {
        int mostOrLeastOccurrencesOfAnyWord = returnMostOrLeastOccurrences(mostOrLeast);

        StringBuilder wordsUnderCriteria = new StringBuilder();

        for(Map.Entry<String, Integer> word: trackUniqueWords.entrySet()) {
            if(word.getValue() == mostOrLeastOccurrencesOfAnyWord) {
                wordsUnderCriteria.append("The word: \"" + word.getKey() + "\"" + " is a word that occurs the " + mostOrLeast + ". It occurs specifically " + word.getValue() + " times!\n");
            }
        }
        return wordsUnderCriteria.toString();
    }

    private static int returnMostOrLeastOccurrences(String mostOrLeast) {
        return mostOrLeast.equals("most") ? Collections.max(trackUniqueWords.values()) : Collections.min(trackUniqueWords.values());
    }

    public static String longestWords() {
        List<String> longestWords = trackUniqueWords.keySet()
                .stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        return longestWords.toString();

    }
}
