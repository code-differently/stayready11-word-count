package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.*;

import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordCounter {
    //sorts the words alphabetically
    private TreeMap<String, Integer> trackUniqueWords;
    //static to prevent garbage collection
    private final static Logger myLogger = Logger.getLogger("com.codedifferently.wordcounter");

    public WordCounter() {
        trackUniqueWords = new TreeMap<String, Integer>();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Kaveesha\\Github\\devCodeDifferently\\stayReadyLabs\\stayready11-word-count\\TheModernPrometheus.txt");
        WordCounter wordCounter = new WordCounter();
        wordCounter.readFile(file);

        myLogger.info(wordCounter.getOccurrencesOfWords());
        myLogger.info(wordCounter.getNumberOfUniqueWords());
        myLogger.info(wordCounter.getMostOrLeastUsedWords("most"));
        myLogger.info(wordCounter.getMostOrLeastUsedWords("least"));
        myLogger.info(wordCounter.getLongestWords());
    }

    public TreeMap<String, Integer> getTrackUniqueWords() {
        return trackUniqueWords;
    }

    //user shouldn't have to set the hashmap, only get it after operations

    public void readFile(File file) {
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            while(in.hasNext()) {
                String individualWord = in.next().toLowerCase();
                //replace a character that is not a-z with a inserting nothing.
                // (I don't check for A-Z because I change the string to lower case)
                individualWord = individualWord.replaceAll("[^a-z]", "");
                incrementOrPlaceValueInTreeMap(individualWord, trackUniqueWords);
            }
        }
        catch(FileNotFoundException fileNotFoundException) {
            myLogger.severe("File cannot be found. Try again another time.");
            fileNotFoundException.printStackTrace();
        }
    }

    public String getNumberOfUniqueWords() {
        return "There are: " + trackUniqueWords.size() + " unique words excluding non alphabetic characters.\n";
    }

    private void incrementOrPlaceValueInTreeMap(String individualWord, TreeMap<String, Integer> words) {
        if(words.containsKey(individualWord)) {
            words.put(individualWord, words.get(individualWord) + 1);
        }
        else {
            words.put(individualWord, 1);
        }
    }

    public String getOccurrencesOfWords() {
        StringBuilder occurrencesOfWords = new StringBuilder();
        for(Map.Entry<String, Integer> word: trackUniqueWords.entrySet()) {
            occurrencesOfWords.append("The word: \"" + word.getKey() + "\" occurs " + word.getValue() + " times.\n");
        }
        return occurrencesOfWords.toString();
    }

    public String getMostOrLeastUsedWords(String mostOrLeast) {
        int mostOrLeastOccurrencesOfAnyWord = returnMostOrLeastOccurrences(mostOrLeast);

        StringBuilder wordsUnderCriteria = new StringBuilder();

        for(Map.Entry<String, Integer> word: trackUniqueWords.entrySet()) {
            if(word.getValue() == mostOrLeastOccurrencesOfAnyWord) {
                wordsUnderCriteria.append("The word: \"" + word.getKey() + "\"" + " is a word that occurs the " + mostOrLeast + ". It occurs " + word.getValue() + " times!\n");
            }
        }
        return wordsUnderCriteria.toString();
    }

    private int returnMostOrLeastOccurrences(String mostOrLeast) {
        return mostOrLeast.equals("most") ? Collections.max(trackUniqueWords.values()) : Collections.min(trackUniqueWords.values());
    }

    public String getLongestWords() {
        List<String> longestWords = trackUniqueWords.keySet()
                .stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        //need it to be in descending order so that I can access the longest words first
        Collections.reverse(longestWords);
        return convertLongestWordsToString(longestWords);
    }

    private String convertLongestWordsToString(List<String> longestWords) {
        StringBuilder allLongWords = new StringBuilder();
        String oneOfTheLongestWords = longestWords.get(0);
        int lengthOfLongestWord = oneOfTheLongestWords.length();

        for(int index = 0; index < longestWords.size(); index++) {
            String word = longestWords.get(index);
            if(word.length() == lengthOfLongestWord) {
                allLongWords.append("The word: \"" + word + "\" is one of the words with the longest length of " + lengthOfLongestWord + ".\n");
            }
            else {
                break;
            }
        }
        return allLongWords.toString();
    }

    public String numberOfWordsInString(String value) {
        String[] individualWords = cleanInputAndPutIntoArray(value);
        TreeMap<String, Integer> numUniqueWords = new TreeMap<String, Integer>();
        for(String word: individualWords) {
            incrementOrPlaceValueInTreeMap(word, numUniqueWords);
        }
        return "The number of unique words in the string is: " + numUniqueWords.size() + ".\n";
    }

    private String[] cleanInputAndPutIntoArray(String value) {
        //replace one or more characters that is not a-z with a space.
        // (I don't check for A-Z because I change the string to lower case)
        value = value.toLowerCase().replaceAll("[^a-z]+", " ");
        return value.split(" ");
    }
}
