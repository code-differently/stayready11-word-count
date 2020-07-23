package com.codedifferently.wordcounter;

import java.util.Scanner;

public class main {
    public static void main(String...args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and Welcome to the designated File reader");
        System.out.println("To start please enter the filename of which you want to use!");
        System.out.println("Please enter a filename ending in .txt");
        String fileName = scanner.nextLine();
        System.out.println("This is the complete output of words and their word count:");
        WordCounter counter = new WordCounter();
        System.out.println(counter.outputAll(fileName));
        System.out.println();
        System.out.println("This is the complete output of unique words and their word count:");
        WordCounter counter1 =new WordCounter();
        System.out.println(counter1.outputUnique(fileName));
        System.out.println();
        System.out.println("This is the complete output of alphabetically outputted words and their word count:");
        WordCounter counter2 = new WordCounter();
        System.out.println(counter2.outputAlpha(fileName));
        System.out.println();
        System.out.println("This is the complete output of words sorted Most to Least and their word count:");
        WordCounter counter3 =new WordCounter();
        System.out.println(counter3.outputMostLeast(fileName));
        System.out.println();
        System.out.println("This is the longest word in the file and its word count:");
        WordCounter counter4 = new WordCounter();
        System.out.println(counter4.outputLongestWord(fileName));
        System.out.println();
        System.out.println("Please enter the word you want to see the word count of:");
        String word = scanner.nextLine();
        WordCounter counter5 = new WordCounter();
        System.out.println(counter5.outputWordCount(fileName, word));
    }
}
