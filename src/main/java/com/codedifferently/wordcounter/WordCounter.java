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
        WordCounter wordCounter = new WordCounter();

        wordCounter.keepAskingUserUntilTheyInputTheRightFile();

        wordCounter.performOperationsOnFile();

        wordCounter.askUserForStringToCountWords();
    }

    private void askUserForStringToCountWords() {
        Scanner scanner = new Scanner(System.in);
        myLogger.info("Do you want to find the number of unique alphabetical words in a string? You can enter 'quit' if you want to quit and 'yes' if you want to continue");
        String answer = scanner.next().toLowerCase().trim();
        while(!answer.equalsIgnoreCase("quit")) {
            if(answer.equals("yes") || answer.equals("yea")) {
                scanner.nextLine();
                myLogger.info("What string do you want to input?");
                answer = scanner.nextLine();
                myLogger.info(this.numberOfWordsInString(answer));
            }
            myLogger.info("Do you want to find the number of unique alphabetical words in a string? You can enter 'quit' if you want to quit and 'yes' if you want to continue");
            answer = scanner.next().toLowerCase().trim();
        }
    }

    private void keepAskingUserUntilTheyInputTheRightFile() {
        String path = "";
        File file = null;
        boolean fileNotValid = true;
        while(fileNotValid) {
            try {
                path = this.askUserForFilePath();
                path = path.replace("\\", "\\\\");
                //for some reason it was inserting a newline so I had to take it out
                path = path.replace("\n", "");
                file = new File(path);
                this.readFile(file);
                fileNotValid = false;
            }
            catch(FileNotFoundException fileNotFoundException) {
                myLogger.severe("File cannot be found. Try again please.");
            }
        }
    }

    private String askUserForFilePath() {
        Scanner scanner = new Scanner(System.in);

        myLogger.info("Enter a file path name.");

        return scanner.next() + "\n";
    }

    private void performOperationsOnFile() {
        myLogger.info(this.getOccurrencesOfWords());
        myLogger.info(this.getNumberOfUniqueWords());
        myLogger.info(this.getMostOrLeastUsedWords("most"));
        myLogger.info(this.getMostOrLeastUsedWords("least"));
        myLogger.info(this.getLongestWords());
    }

    public TreeMap<String, Integer> getTrackUniqueWords() {
        return trackUniqueWords;
    }

    //user shouldn't have to set the hashmap, only get it after operations

    public void readFile(File file) throws FileNotFoundException {
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            while(in.hasNext()) {
                String individualWord = in.next().toLowerCase();
                //replace a character that is not a-z with a inserting nothing.
                // (I don't check for A-Z because I change the string to lower case)
                individualWord = individualWord.replaceAll("[^a-z]", "");
                incrementOrPlaceValueInTreeMap(individualWord, trackUniqueWords);
            }
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
