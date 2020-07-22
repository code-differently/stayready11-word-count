package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This class implements a map as a class object that stores words and their
 * occurrences.
 *
 * @author Shania Kamara
 */
public class WordCounter {
    private Map<String, Integer> wordCount;

    public WordCounter() {
        wordCount = new HashMap<>();
    }
    //adds words to counter
    public void addWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < word.length(); i++) {// check each char in string
            if (!Character.isLetterOrDigit(word.charAt(i))) {// if punctuation
                word = word.replaceAll("[^a-zA-Z0-9]", "");// remove
            }
        }
        String smallWord = word.toLowerCase();// negates case

        synchronized (this) {
            if (!wordCount.containsKey(smallWord) && !smallWord.trim().isBlank()) {
                wordCount.put(smallWord, 1);
            } else { //Used word and not white
                wordCount.put(smallWord, wordCount.get(smallWord) + 1); //increment value
            }

        }
    }

    /**
     * Counts the number of individual words in object
     *
     * @return int
     */
    public int numWords() {
        int count = 0;
        for (Integer i : wordCount.values()) {
            if (i >= 1) {
                count++;// increments count for every value that exists
            }
        }
        return count;
    }

    /**
     * Counts the number of individual words in string
     *
     * @return int
     */
    public int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.split("\\s+");
        return words.length;
    }
    //returns most used word in file
    public String mostUsed() {
        String maxKey = null;
        int maxValue = 0;
        for (String i : wordCount.keySet()) {
            wordCount.get(i);
            if (wordCount.get(i) > maxValue) {
                maxKey = i;
                maxValue = wordCount.get(i);
            }
        }
        return maxKey;
    }

    /**
     * Returns a set of keys with the same number of occurrences
     *
     * @param occurrences
     * @return Set
     */
    public Set<String> wordsWithOccurrences(int occurrences) {
        Set<String> exactNum = new HashSet<>();
        for (String i : wordCount.keySet()) {// words in object
            if (occurrences > 0 && !wordCount.isEmpty()) {// nonempty,nonnegative
                if (wordCount.get(i).equals(occurrences)) {// value ==occurrence
                    exactNum.add(i);// adds key to set
                }
            }
        }
        return exactNum;
    }
    //returns longest word in file
    public String longestWord() {
        String longWord = null;
        int max = 0;
        for (String wC : wordCount.keySet()) {
            for (int i = 0; i < wordCount.size(); i++) {
                if (wC.length() > max) {
                    max = wC.length();
                    longWord = wC;
                }
            }
        }
        return longWord;
    }

    public void readWords(List<String> fileNames) {
        Thread[] allThreads = new Thread[fileNames.size()];
        if (!fileNames.isEmpty()) {
            for (int i = 0; i < allThreads.length; i++) {
                allThreads[i] = new Thread(new ReadFiles(fileNames.get(i)));
                allThreads[i].start();
            }
            for (Thread allThread : allThreads) {
                try {
                    allThread.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    //Used to display results
    public String toString() {
        String str = "";
        str += sortMap(wordCount);
        return str;
    }
    //Sorts Keys in alphabetical order
    public static String sortMap(Map<String, Integer> map) {
        String sMap = "";
        List<String> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for (String word : sortedKeys) {
            sMap += (word + " = " + map.get(word) + "\n");
        }
        return sMap;
    }

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        String str,input;
        Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
        wc.readWords(Arrays.asList(str));
        System.out.println(wc.toString());
        System.out.println("Unique words: " + wc.numWords());
        System.out.println("Least Used Words: " + wc.wordsWithOccurrences(1));
        System.out.println("Most Used Word: " + wc.mostUsed());
        System.out.println("The Longest Word is " + wc.longestWord());
        WordCounter in=new WordCounter();
        input=sc.nextLine();
        String[] arr=input.split(" ");
        for(String i:arr){
            in.addWord(i);
        }
        System.out.println(in.toString());
    }

    /**
     * Inner class that implements Runnable interface
     */
    public class ReadFiles implements Runnable {
        private String file;// "key" to open file

        public ReadFiles(String file) {
            this.file = file;
        }

        public void run() {
            // opens file
            // one thread per file
            Scanner scan;
            try {
                scan = new Scanner(new File(file));
                while (scan.hasNext()) {
                    addWord(scan.next());
                }
                scan.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
