package com.codedifferently.wordcounter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException{

        WordCounter wc = new WordCounter();
        Scanner sc = new Scanner(System.in);
        File file;

        System.out.print("\n\nWhat file do you want to use? ");
        String fileName = sc.nextLine();

        if(!(wc.checkFileName(fileName)))
            fileName += ".txt";

        file = new File(fileName);
        
        System.out.println("");
        wc.addToMap(file);
        System.out.print("\nThe number of unique words in the file: " + wc.uniqueWordCount());

        System.out.print("\nThe most used word from the file: " + wc.mostUsedWord());
        System.out.print("\nThe least used word from the file: " + wc.leastUsedWord());
        System.out.print("\nThe longest word from the file: " + wc.longestWord());

        System.out.print("\n\nPick a word that you want to know the occurrences of: " );
        String word = sc.nextLine();
        sc.close();
        System.out.println("Number of occurrences of " + word + ": " + wc.getWordCount(word));
    }
}